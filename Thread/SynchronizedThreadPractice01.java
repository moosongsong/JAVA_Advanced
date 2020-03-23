package 쓰레드;
//싱크로나이즈 : 한번에 접근에 끝날 때까지 한 객체만 허용//동기화
//상호배제 : 키가 없으면 접근을 허용하지 않는다.
//사용하고 있는 객체가 키를 반납할때 까지 기다려야 한다. 이 키가 뮤텍스

class KakaoBank{
	private String account;
	private int balance;//critical section - 임계영역 -> 공유객체에 대한 우선순위 싸움이 발생한다.
	
//	private volatile boolean isReady;//호출되는 지점에서 최적화 하지 않는다.
	
	public KakaoBank(String account, int balance) {
		super();
		this.account = account;
		this.balance = balance;
//		this.isReady = false;
	}
	public String getAccount() {
		return account;
	}
	public int getBalance() {
		return balance;
	}
	
//	public boolean isReady() {//돈이 입금 되었니?
//		return isReady;
//	}
//	public void setReady(boolean isReady) {
//		this.isReady = isReady;
//	}
	public void setAccount(String account) {
		this.account = account;
	}
	public void deposit(int balance) {
		this.balance += balance;
	}
	public boolean withdraw(int balance) {
		if(balance<=this.balance) {
			this.balance -= balance;
			return true;
		}
		return false;
	}
}

class Mommy extends Thread{
	private KakaoBank bank;

	public Mommy(KakaoBank bank) {
		this.bank = bank;
	}
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Mommy : + 1000won");
		bank.deposit(1000);
		synchronized (bank) {
			bank.notify();//알려주기
//			bank.notifyAll();//블록 걸려 있는 아이들를 모두 깨운다.
		}
//		bank.setReady(true);
	}
}

class Son extends Thread{
	private KakaoBank bank;

	public Son(KakaoBank bank) {
		this.bank = bank;
	}
	
	public void run() {
//		int i=0;
//		while(bank.isReady()==false) {//cpu 사용량이 급증.
//			i++;
//			try {
//				Thread.sleep(5);// 이방법을 쓰게 되면 cpu 사용량은 줄어들지만 시간차가 발생하게 된다....
//			} catch (Exception e) {
//				
//			}
//		}
		int money=1000;
		if(bank.getBalance()<money) {
			synchronized (bank) {
				try {
					bank.wait();//기다리기
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		boolean temp = bank.withdraw(1000);
		if(temp) {
			System.out.println("Son : -1000won ");
		}
		else {
			System.out.println("fail");
		}
	}
}

public class SynchronizedThreadPractice01 {
	public static void main(String [] args) {
		KakaoBank bank = new KakaoBank("우리집통장", 0);
		Thread mom = new Mommy(bank);
		Thread son = new Son(bank);
		
		mom.start();
		son.start();//위의 공유 객체에 대한 우선순위 싸움이 발생한다.
	}
	
}
