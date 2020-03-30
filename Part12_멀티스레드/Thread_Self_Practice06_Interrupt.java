package Part12Main;


class PrintThread2 extends Thread{
	@Override
	public void run() {
		while(true) {
			System.out.println("running");
			if(Thread.interrupted()) {
				break;
			}
		}
		System.out.println("resources clear");
		System.out.println("process is end");
	}
}

public class Thread_Self_Practice06_Interrupt {

	public static void main(String[] args) {
		Thread thread = new PrintThread2();
		thread.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
		}
		thread.interrupt();
	}

}
