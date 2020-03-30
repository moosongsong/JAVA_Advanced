package Part12Main;
import java.util.concurrent.Callable;
//Page 636
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Thread_Self_Practice11_Callable {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		Callable<Integer> task = new Callable<Integer>() {
			
			@Override
			public Integer call() throws Exception {
				int sum=0;
				for (int i = 1; i <= 10; i++) {
					sum+=i;
				}
				return sum;
			}
		};
		Future<Integer>future = executorService.submit(task);
		
		try {
			int sum = future.get();
			System.out.println("result : "+sum);
			System.out.println("task is end");
		} catch (Exception e) {
			System.out.println("Exception is happened"+e.getMessage());
		}
		executorService.shutdown();
	}

}
