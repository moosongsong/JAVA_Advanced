package ������;

class HanaBank{
	private String account;
	private int balance;
	
	public HanaBank(String account, int balance) {
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
//	public boolean withdraw(int balance) {
//		if(balance<=this.balance) {
//			this.balance -= balance;
//			return true;
//		}
//		return false;
//	}
	public synchronized boolean withdraw(int balance) { //�Լ��� ����ɶ� ���� �ٸ� ������� ��ٷ���..
		if(balance<=this.balance) {//method ����ȭ
			this.balance -= balance;
			return true;
		}
		return false;
	}
	
}
//public boolean withdraw(int balance) { 
//	synchronized (this) {//�̷��� this�� ��밡���ϴ�.
//		if(balance<=this.balance) {
//			this.balance -= balance;
//			return true;
//		}
//		return false;
//	}
//}

class User implements Runnable{
	private HanaBank bank;
	private String name;
	
	public User(HanaBank bank, String name) {
		this.bank = bank;
		this.name=name;
	}
	public HanaBank getBank() {
		return bank;
	}
	public void setBank(HanaBank bank) {
		this.bank = bank;
	}
	 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			int money=1000;
//			synchronized (bank) {
				boolean temp=bank.withdraw(money);
				System.out.println(i+", "+name+": -"+money);
				System.out.println("remains : "+bank.getBalance());
//			}
		}
	}
}

public class SynchronizedThreadPractice03 {

	public static void main(String[] args) {
		HanaBank bank = new HanaBank("Hana", 10000);
		Thread t1 = new Thread(new User(bank, "Hope"));
		Thread t2 = new Thread(new User(bank, "V"));
		t1.start();
		t2.start();
		//�޼ҵ� ����ȭ vs ������ȭ 
		//�Ϻθ� ����� ��� �޼ҵ� ��ü�� ��״� �ͺ��� ���� ����ϴ� ���� ȿ�����̴�
	}
}
