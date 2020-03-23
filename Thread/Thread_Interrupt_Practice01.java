package 쓰레드;

public class Thread_Interrupt_Practice01 {

	public static void main(String[] args) {
		Thread t1 = new Thread() {
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println(i+"번 반복");
					try {
						Thread.sleep(500);//대기중인 상태에서 인터럽트 발생
					} catch (InterruptedException e) {
						System.out.println("인터럽트 예외 발생");
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
