package ����������Ʈ;

//1.
interface Printable {
	void print(String name);
}

//2.
interface Calculator {
	int sum(int x, int y);
}

//3.
interface Fightable {

	void fight(String weaponName);
}

class Knight {
	void fight(Fightable f, String weapon) {
		f.fight(weapon);
	}
}

//4.
interface Cal {
	int max(int a, int b);
}

class Com {
	public int comcalc(Cal cal, int x, int y) {
		return cal.max(x, y);
	}
}

//5.
class Com348 {
	int x;
	int y;

	public Com348(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int calc(Cal cal) {
		return cal.max(this.x, this.y);
	}
}

public class LambDa_Practice01 {

	public static void main(String[] args) {
		// 1.
		// ���� ����ϴ� �������̽� ���� ���
		Printable p1 = new Printable() {

			@Override
			public void print(String name) {

			}
		};
		// ���ٽ��� �̿��� ���� ���
		Printable p2 = (str) -> { // ��ü ��ü�� Printable
			// �μ��� �ϳ��� ��� ��ȣ�� ���� �ʾƵ� �ȴ�.
			// ���๮�� �ϳ��� ���, �߰�ȣ�� ������� �ʾƵ� �ȴ�.

		};

		//
		// 2.
		Calculator c = (a, b) -> {// �ϳ��� ���������� �ΰ��� ������
			return a + b;
		};

		System.out.println(c.sum(10, 20));

		//
		// 3.
		Knight k = new Knight();
		k.fight((weaponName) -> {
			System.out.println("�ο�� ������ ȣ��Ǿ����ϴ�.");
		}, "��");

		//
		// 4.
		Com t = new Com();
		int you = t.comcalc((a, b) -> {
			if (a > b) {
				return a;
			}
			return b;
		}, 10, 20);
		System.out.println(you);

		//
		// 5.
		Com348 t2 = new Com348(100, 200);
		int m = t2.calc((a, b) -> {
			if (a > b) {
				return a;
			}
			return b;
		});
		System.out.println(m);
	}
}
