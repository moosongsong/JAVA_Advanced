package Part12Main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Thread_Self_Practice12_ResultByRunnable {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		System.out.println("작업 처리 요청");
		class Task implements Runnable{
			Result result;
			Task(Result result){
				this.result=result;
			}
			@Override
			public void run() {
				int sum=0;
				for (int i = 1; i <= 10; i++) {
					sum+=i;
				}
				result.addValue(sum);
			}
			
		}
		Result result = new Result();
		Runnable task1 = new Task(result);
		Runnable task2 = new Task(result);
		
		Future<Result>future1 = executorService.submit(task1, result);
		Future<Result>future2 = executorService.submit(task2, result);
		
		try {
			result = future1.get();
			result = future2.get();
			System.out.println("result : "+result.accumValue);
			System.out.println("Task is end");
		} catch (Exception e) {
			System.out.println("excepiton"+e.getMessage());
		}
		executorService.shutdown();
	}

}


class Result {
	int accumValue;
	synchronized void addValue(int value) {
		accumValue+=value;
	}
}