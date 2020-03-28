package ����������Ʈ;

import java.util.Comparator;

class Box implements Comparable<Box> {
	int width;
	int height;
	Comparator<Box> comp;

	public Box(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		this.comp = null;
	}

	public int getArea() {
		return width * height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Comparator<Box> getComp() {
		return comp;
	}

	public void setComp(Comparator<Box> comp) {
		this.comp = comp;
	}

	@Override
	public int compareTo(Box o) {
		return comp.compare(this, o);
	}

}

public class AppStart {

	public static void main(String[] args) {
//		Box b1 = new Box(10, 10);
//		Box b2 = new Box(11, 20);
//
//		Comparator<Box> comparator = ((a, b) -> {
//			return a.getArea() > b.getArea() ? a.getArea() : b.getArea();
//		});
//
//		// b1�� b2�� ������ ���ϴ� ���ٽ��� �ۼ��ϱ�.b1�� ������ �� ũ�� ���� ����,
//		// ������ 0�� b2�� ������ �� ũ�� ���� ���� ��ȯ�Ѵ�.
//		if (comparator.compare(b1, b2) > 0) {
//			System.out.println("b1�� ��ŭ");
//		} else if (comparator.compare(b1, b2) < 0) {
//			System.out.println("b2�� ��ŭ");
//		} else {
//
//		}

		Box b = new Box(100, 100);
		b.setComp((o1, o2) -> {
			if (o1.getArea() > o2.getArea()) {
				return 1;
			} else if (o1.getArea() < o2.getArea()) {
				return -1;
			}
			return 0;
		});
		int n = b.compareTo(new Box(50, 50));
		System.out.println(n);
	}
}
