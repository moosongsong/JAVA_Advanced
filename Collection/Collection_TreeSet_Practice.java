package Part14Main;

import java.util.TreeSet;

class Bee implements Comparable<Bee>{
	private String name;
	private int age;
	private int weight;

	public Bee(String name, int age, int weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return "Bee [name=" + name + ", age=" + age + ", weight=" + weight + "]";
	}
	//이름으로 비교하기
//	@Override
//	public int compareTo(Bee o) {
//		return this.name.compareTo(o.name);
//	}
	//나이로 비교하기
	@Override
	public int compareTo(Bee o) {
		return -Integer.valueOf(this.age).compareTo(o.age);
	}
}

public class Collection_TreeSet_Practice {

	public static void main(String[] args) {
		TreeSet <Integer> ts = new TreeSet<>();
		ts.add(30);
		ts.add(10);
		ts.add(20);
		ts.add(5);
		ts.add(3);
		
		for (Integer integer : ts) {
			System.out.println(integer);
		}
		
		TreeSet<String>tt = new TreeSet<String>();
		tt.add("jin");
		tt.add("suga");
		tt.add("rm");
		tt.add("taetae");
		for (String str : tt) {
			System.out.println(str);
		}
		
		TreeSet<Bee>ta = new TreeSet<Bee>();
		ta.add(new Bee("jin",1,1));
		ta.add(new Bee("suga",2,2));
		ta.add(new Bee("rm",3,3));
		ta.add(new Bee("taetae",4,4));
		for (Bee i : ta) {
			System.out.println(i);
		}
	}

}
