package ������;
//join() ����ϱ�
public class ThreadPractice04 {

	public static void main(String[] args) {
		Thread t1 = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName()+", "+i);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		t1.start();
		try {
			t1.join();//������ t1�� ����ɶ����� ��ٷ� �ִ� �ž�.
			//t1�� ������ ȣ��. main�� t1 ���� ���� ������ �ϴ°���.
			//t1�� ����Ǹ� main�� �����尡 ������ �ȴ�.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"����");
	}

}
