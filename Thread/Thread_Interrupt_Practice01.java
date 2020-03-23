package ������;

public class Thread_Interrupt_Practice01 {

	public static void main(String[] args) {
		Thread t1 = new Thread() {
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println(i+"�� �ݺ�");
					try {
						Thread.sleep(500);//������� ���¿��� ���ͷ�Ʈ �߻�
					} catch (InterruptedException e) {
						System.out.println("���ͷ�Ʈ ���� �߻�");
						break;
					}
				}
				System.out.println(Thread.currentThread().getName());
			}
		};
		t1.start();
		try {
			Thread.sleep(5000);
			t1.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
