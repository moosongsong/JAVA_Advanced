package 쓰레드;

class Computer extends Thread{
	private int result=0;
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			result += i;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("계산 완료!");
	}

	public int getResult() {
		return result;
	}

}

public class ThreadPractice05 {

	public static void main(String[] args) {
		Thread t1 = new Computer();
		t1.start();
		System.out.println("result : "+((Computer)t1).getResult());
		//0이 나온다. 연산이 시작되기도 전에 값을 참조했기 때문이다.
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		t1.start();
		System.out.println("result : "+((Computer)t1).getResult());
		//결과가 올바르게 나온다.
		System.out.println("Main 종료");
	}

}
