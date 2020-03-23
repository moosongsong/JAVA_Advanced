interface Comparable<T>{//implement 할때 타입을 지정하지 않는 방법이 있다.
	int compareTo(T a);
}

class Cube<T> implements Comparable<T>{//implement 할때 타입을 지정하지 않는 방법이 있다.
	private int size;
	
	public Cube(int a) {
		this.size = a;
	}

	@Override
	public int compareTo(T a) {
		
		return (this.size-((Cube)a).size);//강제 조치...
	}
}

class BigHit implements Comparable<Integer>{//타입을 결정.
	private int size;
	
	public BigHit(int size) {
		this.size = size;
	}

	@Override
	public int compareTo(Integer a) {
		return this.size-a.intValue();
	}
}

public class Generic_Type_Interface_Practic {

	public static void main(String[] args) {
		BigHit c = new BigHit(new Integer(10));
		int result = c.compareTo(20);
		System.out.println(result);
	}
}
//moosongsong
