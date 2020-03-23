package 쓰레드;

public class Thread_Group_Practice01 {

	public static void main(String[] args) {
		ThreadGroup tg = new ThreadGroup("My Work Group");
		for (int i = 0; i < 10; i++) {
			Thread t1 = new Thread(tg, new Runnable() {//그룹, 객체, 이름
				
				@Override
				public void run() {
					for (int j = 0; j < 100; j++) {
						System.out.println(Thread.currentThread().getName()+":"+j);
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							break;
						}
					}
					System.out.println(Thread.currentThread().getName()+"is end.");
				}
			}, i+"work");
			t1.start();
		}
		try {
			Thread.sleep(3000);
			tg.interrupt();//그룹으로 묶으면 일괄적으로 인터럽트를 걸 수 있음.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
