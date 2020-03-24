//join을 이용한 동기화
public class Bakery_AppStart {

	public static void main(String[] args) {
		Bakery bakery = new Bakery();
		bakery.add("고구마빵");
		bakery.add("카스테라");
		bakery.add("마늘빵");
		bakery.add("바게트");
		
		//chain
		Thread t1 = new Thread(new Student(bakery, "Jin", Thread.currentThread()));
		Thread t2 = new Thread(new Student(bakery, "Suga", t1));
		Thread t3 = new Thread(new Student(bakery, "Hope", t2));
		Thread t4 = new Thread(new Student(bakery, "JK", t3));
		Thread t5 = new Thread(new Student(bakery, "JIMIN", t4));
		
//		t1.start();
//		t2.start();
//		t3.start();
//		t4.start();
		t5.start();//책임연쇄 패턴
		//fly weight Pattern
		
		System.out.println("main is end");
	}

}
