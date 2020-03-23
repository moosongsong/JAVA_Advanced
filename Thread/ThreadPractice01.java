package ������;

//Thread ��� �̿��ϱ�
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

//Runnable �̿��ϱ�
class Counter2 implements Runnable{
	private int count;

	public Counter2() {
		this.count = 0;
	}

	public int getCount() {
		return count;
	}

	public void run() {//run() ��ŭ�� �ݵ�� �����Ǿ� �־�� �Ѵ�.
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
		//Thread �̿�
		Counter coun = new Counter();
		coun.start();//������ ������ �۾������� �ʿ��ϴ�. �� run();�� ���� �۾������� �����ϰ�
		//�� ������ �̿��� ���� ������� ��� ���� �۾��� �� ���ֵ��� �ϴ� �޼ҵ� �̴�.
		//run(); �۾��� ������ �ش� ������� �������.
		System.out.println("Counter1 end");
		
		//Runnable �̿�
		Counter2 coun2 = new Counter2();
		Thread t1 = new Thread(coun2);
		t1.setDaemon(false);//���ξ����忡�� ���� ������. ���� ������ ����Ǹ� �� �����嵵 ���� ����ȴ�.
		t1.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Counter2 end");
		
	}
}
