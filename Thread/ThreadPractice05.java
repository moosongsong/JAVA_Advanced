package ������;

class Computer extends Thread{
	private int result=0;
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			result += i;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("��� �Ϸ�!");
	}

	public int getResult() {
		return result;
	}

}

public class ThreadPractice05 {

	public static void main(String[] args) {
		Thread t1 = new Computer();
		t1.start();
		System.out.println("result : "+((Computer)t1).getResult());
		//0�� ���´�. ������ ���۵Ǳ⵵ ���� ���� �����߱� �����̴�.
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		t1.start();
		System.out.println("result : "+((Computer)t1).getResult());
		//����� �ùٸ��� ���´�.
		System.out.println("Main ����");
	}

}
