package Threadexe;

public class Student implements Runnable{
	private Bakery bakery;
	private String name;
	
	public Student(Bakery bakery, String name) {
		this.bakery = bakery;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}
	
	@Override
	public void run() {
		String bread=null;
		synchronized (bakery) {
			try {
				bakery.wait();
			}
			catch (InterruptedException e) {
			}
		}
//		synchronized (bakery) {
			bread = bakery.getBread();
//		}
		if(bread!=null) {
			System.out.println(name+" gets "+bread+".");
		}else {
			System.out.println("Fail");
		}
		
		synchronized (bakery) {
			bakery.notify();
		}
	}
}
