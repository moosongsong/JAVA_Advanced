package Part_13_Question;

class Container<T>{
	private T name;
	
	public void set(T name) {
		this.name=name;
	}
	
	public T get() {
		return name;
	}
}

public class Q13_2 {

	public static void main(String[] args) {
		Container<String> container1 = new Container<String>();
		container1.set("JIN");
		String str = container1.get();
		System.out.println(str);
		
		Container<Integer>container2 = new Container<Integer>();
		container2.set(6);
		int value = container2.get();
		System.out.println(value);
	}
}