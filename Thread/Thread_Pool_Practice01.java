package 쓰레드;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PoolPool extends Thread{
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+": "+i);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Thread_Pool_Practice01 {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 10; i++) {
			Thread t1 = new Thread(new PoolPool());
			executorService.submit(new PoolPool());
		}
		executorService.shutdown();//반드시 해주세용
	}
}


