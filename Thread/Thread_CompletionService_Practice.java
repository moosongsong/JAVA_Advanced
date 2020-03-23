package 쓰레드;


import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


class Cube{//공유객체
	private int number;

	public Cube() {
		this.number = 0;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public void add(int a) {
		this.number+=a;
//		System.out.println(number);
	}
}

class MyCubeThread implements Runnable{
	private Cube cube;

	public MyCubeThread(Cube cube) {
		this.cube = cube;
	}

	@Override
	public void run() {
		int sum = 0;
		for (int i = 0; i <10; i++) {
			sum+=i;
//			System.out.println(i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		cube.add(sum);
//		System.out.println(sum);
	}
	
	
}

public class Thread_CompletionService_Practice {

	public static void main(String[] args) {
		Cube cube = new Cube();
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		CompletionService <Cube>completionService = new ExecutorCompletionService<Cube>(executorService);
		
		for (int i = 0; i < 10; i++) {
			completionService.submit(new MyCubeThread(cube), cube);
		}
		
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					try {
						Future<Cube> future = completionService.take();
						Cube c =future.get();
						System.out.println(c.getNumber());
					} catch (InterruptedException e) {
						break;
					} catch (ExecutionException e) {
						e.printStackTrace();
						break;
					}
				}
			}
		});
		executorService.shutdown();
		System.out.println("Main is end");
	}

}
