package 쓰레드;

class KakaoBank{
	private String account;
	private int balance;
	
	public KakaoBank(String account, int balance) {
		super();
		this.account = account;
		this.balance = balance;
	}
	public String getAccount() {
		return account;
	}
	public int getBalance() {
		return balance;
	}
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
		
		for (int i = 0; i < 10; i++) {
			bank.deposit(1000);
			System.out.println("Mommy : + 1000won");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (bank) {
				bank.notify();
			}
			try {
				synchronized (bank) {
					bank.wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Son extends Thread{
	private KakaoBank bank;

	public Son(KakaoBank bank) {
		this.bank = bank;
	}
	
	public void run() {

		for (int i = 0; i < 10; i++) {
			synchronized (bank) {
				try {
					bank.wait();//기다리기
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			boolean temp = bank.withdraw(1000);
			if(temp) {
				System.out.println("Son : -1000won ");
			}
			else {
				System.out.println("fail");
			}
			synchronized (bank) {
				bank.notify();
			}
		}
	}
}

public class SynchronizedThreadPractice02 {
	public static void main(String [] args) {
		KakaoBank bank = new KakaoBank("우리집통장", 0);
		Thread mom = new Mommy(bank);
		Thread son = new Son(bank);
		mom.start();
		son.start();
	}
}
