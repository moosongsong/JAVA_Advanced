package Part_12_Question;

class MovieThread2 extends Thread{
	@Override
	public void run() {
		while(true) {
			System.out.println("�������� ����մϴ�.");
			
			if(Thread.interrupted()) {
				break;
			}
		}
	}
}

public class Q12_8 {

	public static void main(String[] args) {
		Thread thread = new MovieThread2();
		thread.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {		}
		thread.interrupt();
	}

}
