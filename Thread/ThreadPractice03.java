package 쓰레드;

class MyThread extends Thread{
	protected int a;

	public MyThread(int a) {
		this.a = a;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
}

class Bank{//Thread, Runnable 을 사용하지 않고 멀티쓰레딩은 어떻게 할까???
	int balance;
}

class MyBank extends Bank implements Runnable{//요렇게 하면 해결할 수 있다.
	
	@Override
	public void run() {
		balance=0;
		for (int i = 0; i < 10; i++) {
			balance++;
			try {
				Thread.sleep(500);
			}catch (InterruptedException e) {
			}
			System.out.println("balance, "+balance);
		}
	}
	
}
//구현하기 싫다면
//abstract class MyBank extends Bank implements Runnable{}

public class ThreadPractice03 {

	public static void main(String[] args) {
		int num=100;//익명중첩클래스.
		Thread t1 = new MyThread(num) {//내부에서 num을 바꾼다고 해도 외부에서 사용되지 않는다.argument 이기 때문
			//num은 단순한 값인거야.'실인수' 이 내부에서는 final로 취급된다. 따라서 내부에서 변경 불가...
			public void run() {
				for (int i = 0; i < 10; i++) {
					a++;
					try {
						Thread.sleep(500);
					}catch (InterruptedException e) {
					}
					System.out.println("a, "+a);
				}
			}
		};
		t1.start();	
		
		Thread t2 = new Thread(new MyBank());
		t2.start();
	}
}
