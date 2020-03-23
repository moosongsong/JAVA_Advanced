package 쓰레드;
//join() 사용하기
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
			t1.join();//메인은 t1이 종료될때까지 기다려 주는 거얀.
			//t1의 조인을 호출. main이 t1 한테 나도 끼워줘 하는고임.
			//t1이 종료되면 main의 쓰레드가 진행이 된다.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"종료");
	}

}
