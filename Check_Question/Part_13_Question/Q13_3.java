package Part_13_Question;

class Container2 <K, V>{
	private K name;
	private V job;
	
	public void set(K name, V job) {
		this.name=name;
		this.job=job;
	}
	public K getKey() {
		return name;
	}
	public V getValue() {
		return job;
	}
}

public class Q13_3 {

	public static void main(String[] args) {
		Container2<String, String> container1 = new Container2<String, String>();
		container1.set("JIN", "ACTOR");
		String name1 = container1.getKey();
		String job = container1.getValue();
		System.out.println(name1 +", "+job);
		
		Container2<String, Integer> container2 = new Container2<String, Integer>();
		container2.set("SUGA", 28);
		String name2 = container2.getKey();
		int age = container2.getValue();
		System.out.println(name2+", "+age);
	}

}
