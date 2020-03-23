package ������;


public class ThreadPractice02 {
	//����ǰ� �ִ� �����带 Sleep ���·� �ξ�� ���ͷ�Ʈ�� �����ϴ�.
	public static void main(String[] args) {
		//Thread �̿��ϱ�
		Thread t1 = new Thread("1��° ������") {
			//�͸�Ŭ���� : ���� ���� �޼ҵ� ���� ���� ���� ����. �� ������ final�̾��...�ٲܼ� ����
			//���ο� ����� ���� Ŭ������ �������� ����....�Ф�
			//����Ŭ������ �μ��� �ϳ��� �ϴ� �����ڸ� ȣ���Ͽ� �͸�Ŭ������ ����
			public void run() {//�͸� ���� ��ü�� �ʵ�� �ܺο��� �������� ����.
				//Thread Ÿ������ ���� ������ Thread Ŭ���� ���� �ش� �ʵ尡 ����.
				//���� ������ ���� �ʴ´�.
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName()+", "+i);
					//������ �����带 ��ȯ�Ѵ�.
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		//Runnable �̿��ϱ�
		Thread t2 = new Thread(new Runnable() {//�͸��� �ƴϴ�. �ȿ� �ִ� Runnable�� �͸� Ŭ����
			//�������̽��̱⿡ �����ڸ� ����� �� ����.
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
		},"2��° ������");//���� �������� �ٸ� �����ڸ� ȣ���Ͽ� �����Ͽ���.
		
		t1.start();
		t2.start();
		
		System.out.println(Thread.currentThread().getName()+", ����");
		
		System.out.println("���μ����� �����մϴ�.");
	}
}
