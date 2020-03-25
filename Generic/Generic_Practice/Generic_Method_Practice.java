class Suga<T>{
	T r;

	public T getR() {
		return r;
	}
	public void setR(T r) {
		this.r = r;
	}
	@Override
	public String toString() {
		return "Suga [r=" + r + "]";
	}
}

class Maker{
	public <T>Suga func(T a) {//반환값 이전에 Type을 명시해주어야 한다.
		System.out.println("Generic Method");
		Suga<T> s = new Suga<T>();
		s.setR(a);
		return s;
	}
}

public class Generic_Method_Practice {

	public static void main(String[] args) {
		Suga s = new Suga();
		Suga s2 = new Maker().<Integer>func(100);
		System.out.println(s);
		System.out.println(s2);
	}
}
