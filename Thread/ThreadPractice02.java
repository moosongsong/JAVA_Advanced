package 쓰레드;


public class ThreadPractice02 {
	//실행되고 있는 쓰레드를 Sleep 상태로 두어야 인터럽트가 가능하다.
	public static void main(String[] args) {
		//Thread 이용하기
		Thread t1 = new Thread("1번째 쓰레드") {
			//익명클래스 : 장점 메인 메소드 내의 변수 참조 가능. 단 변수는 final이어야...바꿀수 없숴
			//내부에 멤버를 갖는 클래스를 구현하지 못함....ㅠㅠ
			//상위클래스의 인수를 하나로 하는 생성자를 호출하여 익명클래스로 구현
			public void run() {//익명 구현 객체의 필드는 외부에서 참조하지 못함.
				//Thread 타입으로 보기 때문에 Thread 클래스 내에 해당 필드가 없다.
				//따라서 승인이 나지 않는다.
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName()+", "+i);
					//현재의 쓰레드를 반환한다.
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		//Runnable 이용하기
		Thread t2 = new Thread(new Runnable() {//익명이 아니다. 안에 있는 Runnable이 익명 클래스
			//인터페이스이기에 생성자를 사용할 수 없다.
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName()+", "+i);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		},"2번째 쓰레드");//따라서 쓰레드의 다른 생성자를 호출하여 구현하였다.
		
		t1.start();
		t2.start();
		
		System.out.println(Thread.currentThread().getName()+", 종료");
		
		System.out.println("프로세스를 종료합니다.");
	}
}
