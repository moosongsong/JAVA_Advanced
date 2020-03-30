package Part12Main;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Thread_Self_Practice13_CompletionService {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		
		CompletionService<Integer>completionSer = new ExecutorCompletionService<Integer>(executorService);
		
		System.out.println("작업 처리 요청");
		for (int i = 0; i < 3; i++) {
			completionSer.submit(new Callable<Integer>() {
				
				@Override
				public Integer call() throws Exception {
					int sum =0 ;
					for (int j = 1; j <= 10; j++) {
						sum+=j;
					}
					return sum;
				}
			});
		}
		
		System.out.println("처리 완료된 작업 확인 ");
		executorService.submit(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					try {
						Future<Integer>future = completionSer.take();
						int value = future.get();
						System.out.println("result : "+value);
					} catch (Exception e) {
						break;
					}
				}
			}
		});
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		executorService.shutdown();
	}

}
