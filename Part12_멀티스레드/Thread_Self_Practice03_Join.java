package Part12Main;

class SumThread extends Thread{
	private long sum=0L;

	public long getSum() {
		return sum;
	}

	public void setSum(long sum) {
		this.sum = sum;
	}
	
	public void run() {
		for (int i = 1; i <= 100; i++) {
			sum+=i;
		}
	}
}

public class Thread_Self_Practice03_Join {

	public static void main(String[] args) {
		SumThread sumThread = new SumThread();
		sumThread.start();
		
		try {
			sumThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("sum = "+sumThread.getSum());
	}

}
