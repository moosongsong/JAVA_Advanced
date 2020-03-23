package ¾²·¹µå;

class KBBank{
	private int balance;
	
	public KBBank() {
		this(0);
	}

	public KBBank(int balance) {
		this.balance = balance;
	}
	
	public void deposit(int amount) {
		this.balance+=amount;
	}

	public int getBalance() {
		return balance;
	}

}

class Sender implements Runnable{
	private KBBank bank;

	public Sender(KBBank bank) {
		super();
		this.bank = bank;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			bank.deposit(1000);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
}

class Receiver implements Runnable{
	private KBBank bank;

	public Receiver(KBBank bank) {
		super();
		this.bank = bank;
	}

	@Override
	public void run() {
		
		System.out.println("remains:"+bank.getBalance()+"won");
	}
}

public class SynchronizedThreadPractice04 {
	public static void main(String [] args) {
		KBBank bank = new KBBank(0);
		Thread sender = new Thread(new Sender(bank));
		Thread receiver = new Thread(new Receiver(bank));
		
		sender.start();
//		while(sender.getState() != Thread.State.TERMINATED) {
//			;
//		}
		try {
			sender.join();
			receiver.start();
		} catch (Exception e) {
		}
		
//		receiver.start();
		
	}
}
