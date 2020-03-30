package Part12Main;

class WorkObject{
	public synchronized void methodA(){
		System.out.println("ThreadA's Metod A()");
		notify();
		try {
			wait();
		}catch (InterruptedException e) {		}
	}
	
	public synchronized void methodB() {
		System.out.println("ThreadB's Method B");
		notify();
		try {
			wait();
		}catch (InterruptedException e) {		}
	}
}

class ThreadAA extends Thread{
	private WorkObject wokrob;

	public ThreadAA(WorkObject wokrob) {
		super();
		this.wokrob = wokrob;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			wokrob.methodA();
		}
	}
}

class ThreadBB extends Thread{
	private WorkObject workob;

	public ThreadBB(WorkObject workob) {
		super();
		this.workob = workob;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			workob.methodB();
		}
	}
}

public class Thread_Self_Practice04_Wait {
	public void main(String [] args) {
		WorkObject share = new WorkObject();
		
		ThreadAA ta = new ThreadAA(share);
		ThreadBB tb = new ThreadBB(share);
		
		ta.start();
		tb.start();
	}
}
