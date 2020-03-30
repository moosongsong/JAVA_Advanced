package Part12Main;

class ThreadA extends Thread{
	public boolean stop = false;
	public boolean work = true;
	
	public void run() {
		while(!stop) {//
			if(work) {
				System.out.println("Thread A");
			}
			else {
				Thread.yield();
			}
		}
		System.out.println("Thread A is end");
	}
}

class ThreadB extends Thread{
	public boolean stop = false;
	public boolean work = true;
	
	public void run() {
		while(!stop) {//
			if(work) {
				System.out.println("Thread B");
			}
			else {
				Thread.yield();
			}
		}
		System.out.println("Thread B is end");
	}
}

public class Thread_Self_Practice02_Yield {

	public static void main(String[] args) {
		ThreadA ta = new ThreadA();
		ThreadB tb = new ThreadB();
		
		ta.start();
		tb.start();
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		ta.work = false;
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
		}
		ta.work = true;
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
		}
		ta.stop = true;
		tb.stop = true;
	}

}
