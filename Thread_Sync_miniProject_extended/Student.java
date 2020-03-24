public class Student implements Runnable{
	private Bakery bakery;
	private String name;
	private Thread next;
	
	public Student(Bakery bakery, String name, Thread next) {
		this.bakery = bakery;
		this.name = name;
		this.next = next;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}
	
	@Override
	public void run() {

		String bread=null;
		bread = bakery.getBread();
		
		if(bread!=null) {
			System.out.println(name+" gets "+bread+".");
		}else {
			System.out.println("Fail");
		}
		
		try {
			next.start();
		} catch (Exception e) {
			System.out.println("마지막 쓰레드 입니다.");
		}
		
	}
}
