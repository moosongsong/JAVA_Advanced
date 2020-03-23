package ������;
//��ũ�γ����� : �ѹ��� ���ٿ� ���� ������ �� ��ü�� ���//����ȭ
//��ȣ���� : Ű�� ������ ������ ������� �ʴ´�.
//����ϰ� �ִ� ��ü�� Ű�� �ݳ��Ҷ� ���� ��ٷ��� �Ѵ�. �� Ű�� ���ؽ�

class KakaoBank{
	private String account;
	private int balance;//critical section - �Ӱ迵�� -> ������ü�� ���� �켱���� �ο��� �߻��Ѵ�.
	
	private volatile boolean isReady;//ȣ��Ǵ� �������� ����ȭ ���� �ʴ´�.
	
	public KakaoBank(String account, int balance) {
		super();
		this.account = account;
		this.balance = balance;
		this.isReady = false;
	}
	public String getAccount() {
		return account;
	}
	public int getBalance() {
		return balance;
	}
	
	public boolean isReady() {//���� �Ա� �Ǿ���?
		return isReady;
	}
	public void setReady(boolean isReady) {
		this.isReady = isReady;
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
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Mommy : + 1000won");
		bank.deposit(1000);
		bank.setReady(true);
	}
}

class Son extends Thread{
	private KakaoBank bank;

	public Son(KakaoBank bank) {
		this.bank = bank;
	}
	
	public void run() {
		int i=0;
		while(bank.isReady()==false) {//cpu ��뷮�� ����.
			i++;
			try {
				Thread.sleep(5);// �̹���� ���� �Ǹ� cpu ��뷮�� �پ������ �ð����� �߻��ϰ� �ȴ�....
			} catch (Exception e) {
				
			}
		}
		boolean money = bank.withdraw(1000);
		if(money) {
			System.out.println("Son : -1000won "+i );
		}
		else {
			System.out.println("fail");
		}
	}
}

public class SynchronizedThreadPractice01 {
	public static void main(String [] args) {
		KakaoBank bank = new KakaoBank("�츮������", 0);
		Thread mom = new Mommy(bank);
		Thread son = new Son(bank);
		
		mom.start();
		son.start();//���� ���� ��ü�� ���� �켱���� �ο��� �߻��Ѵ�.
	}
	
}
