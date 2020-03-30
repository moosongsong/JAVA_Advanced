package Part12Main;

class DataBox{
	private String data;
	
	public synchronized String getData(){
		if(this.data == null) {
			try {
				wait();
			}catch (InterruptedException e) {			}
		}
		
		String returnVal = data;
		System.out.println(returnVal);
		
		data = null;
		notify();
		return returnVal;
	}
	
	public synchronized void setData(String data) {
		if(this.data!=null) {
			try {
				wait();
			}catch (InterruptedException e) {			}
		}
		this.data = data;
		System.out.println(data);
		notify();
	}
}

class ProducerThread extends Thread{
	private DataBox databox;

	public ProducerThread(DataBox databox) {
		super();
		this.databox = databox;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			String data = "data-"+i;
			databox.setData(data);
		}
	}
}

class ConsumerThread extends Thread{
	private DataBox databox;

	public ConsumerThread(DataBox databox) {
		super();
		this.databox = databox;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			String data = databox.getData();
		}
	}
}

public class Thread_Self_Practice05_Notify {

	public static void main(String[] args) {
		DataBox databox =  new DataBox();
		
		ProducerThread pt = new ProducerThread(databox);
		ConsumerThread ct = new ConsumerThread(databox);
		
		pt.start();
		ct.start();
	}

}
