package Part_12_Question;

class MovieThread extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println("동영상을 재생합니다.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {			}
		}
	}
}

class MusicRunnable implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println("음악을 재생합니다.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {			}
		}
	}
}

public class Q12_2 {

	public static void main(String[] args) {
		Thread t1 = new MovieThread();
		Thread t2 = new Thread( new MusicRunnable());
		t1.start();
		t2.start();
	}

}
