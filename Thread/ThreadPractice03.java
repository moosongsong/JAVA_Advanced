package ������;

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

public class ThreadPractice03 {

	public static void main(String[] args) {
		int num=100;
		Thread t1 = new MyThread(num) {//���ο��� num�� �ٲ۴ٰ� �ص� �ܺο��� ������ �ʴ´�.argument �̱� ����
			//num�� �ܼ��� ���ΰž�.'���μ�' �� ���ο����� final�� ��޵ȴ�. ���� ���ο��� ���� �Ұ�...
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
	}
}
