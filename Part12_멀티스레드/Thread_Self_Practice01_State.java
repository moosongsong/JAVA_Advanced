package Part12Main;

//Page 598
class StatePrintThread extends Thread{
	private Thread targetThread;

	public StatePrintThread(Thread targetThread) {
		this.targetThread = targetThread;
	}
	
	public void run() {
		while(true) {
			Thread.State state = targetThread.getState();
			System.out.println("Target Thread's State : "+ state);
			
			if (state == Thread.State.NEW) {
				targetThread.start();
			}
			
			if(state == Thread.State.TERMINATED) {
				break;
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class TargetThread extends Thread{
	public void run() {
		for (long i = 0; i < 1000000000; i++) {
			;
		}
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (long i = 0; i < 1000000000; i++) {
			;
		}
	}
}

public class Thread_Self_Practice01_State {

	public static void main(String[] args) {
		StatePrintThread statePrint = new StatePrintThread(new TargetThread());
		statePrint.start();
	}

}
