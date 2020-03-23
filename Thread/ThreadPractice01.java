package 쓰레드;

//Thread 상속 이용하기
class Counter extends Thread{
	private int count;

	public Counter() {
		this.count = 0;
	}

	public int getCount() {
		return count;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			count++;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(count);
	}
}

//Runnable 이용하기
class Counter2 implements Runnable{
	private int count;

	public Counter2() {
		this.count = 0;
	}

	public int getCount() {
		return count;
	}

	public void run() {//run() 만큼은 반드시 구현되어 있어야 한다.
		for (int i = 0; i < 10; i++) {
			count++;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(count);
		}
//		System.out.println(count);
	}
}

public class ThreadPractice01 {
	public static void main(String [] srgv) {
		//Thread 이용
		Counter coun = new Counter();
		coun.start();//별도의 쓰레드 작업공간이 필요하다. 즉 run();을 위한 작업공안을 마련하고
		//그 공간을 이용해 메인 스레드와 상관 없이 작업을 할 수있도록 하는 메소드 이다.
		//run(); 작업이 끝나면 해당 쓰레드는 사라진다.
		System.out.println("Counter1 end");
		
		//Runnable 이용
		Counter2 coun2 = new Counter2();
		Thread t1 = new Thread(coun2);
		t1.setDaemon(false);//메인쓰레드에서 만든 쓰레드. 따라서 메인이 종료되면 이 쓰레드도 같이 종료된다.
		t1.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Counter2 end");
		
	}
}
