package 쓰레드;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Thread_Collable_Practice01 {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 10; i++) {
			Future<Integer>future = executorService.submit(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					int sum=0;
					for (int j = 0; j <10; j++) {
						sum+=j;
					}
					return sum;
				}
			});
			try {
				int result = future.get();//스레드가 끝날때 까지 기다려준다. 즉 블락이 걸린다.
				System.out.println(result);
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			} 
		}
		executorService.shutdown();
	}

}
