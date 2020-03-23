package 쓰레드;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Box{
	int number;
	public void add(int a) {
		this.number=a;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
}

class MyBoxControl implements Runnable{
	Box box;

	public MyBoxControl(Box box) {
		this.box = box;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			box.setNumber(box.getNumber()+i);
//			System.out.println(box.getNumber());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Thread_Future_Practice {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Box box =new Box();
		for (int i = 0; i < 10; i++) {
			Future<Box> future = executorService.submit(new MyBoxControl(box), box);
			try {
				Box b = future.get();//submit 내용 끝날때까지 기다리고 있다.
				System.out.println(b.getNumber());
			} catch (Exception e) {
			}
		}
		executorService.shutdown();
		System.out.println(box.getNumber());//550 아닌, 2 가 나온다.
	}

}
