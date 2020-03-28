package 람다프로젝트;

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
//		// b1과 b2의 면적을 비교하는 람다식을 작성하기.b1의 면적이 더 크면 양의 값을,
//		// 같으면 0을 b2의 면적이 더 크면 음의 값을 반환한다.
//		if (comparator.compare(b1, b2) > 0) {
//			System.out.println("b1이 더큼");
//		} else if (comparator.compare(b1, b2) < 0) {
//			System.out.println("b2가 더큼");
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
