package Part14Main;

import java.util.Iterator;
import java.util.TreeSet;

class Person30 implements Comparable<Person30>{
	public String name;
	public int age;
	public Person30(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public int compareTo(Person30 o) {
		if(age<o.age) {
			return -1;
		}
		else if(age == o.age) {
			return 0;
		}
		else {;}
		return 1;
	}

}

public class Comparable_Comparator {

	public static void main(String[] args) {
		TreeSet<Person30> treeSet = new TreeSet<Person30>();
		
		treeSet.add(new Person30("JIN", 29));
		treeSet.add(new Person30("JIMIN", 26));
//		treeSet.add(new Person30("V", 26));
		treeSet.add(new Person30("JK", 24));
		treeSet.add(new Person30("RM", 27));
//		treeSet.add(new Person30("Hope", 27));
		treeSet.add(new Person30("Suga", 28));
		
		Iterator<Person30>it = treeSet.iterator();
		
		while(it.hasNext()) {
			Person30 temp = it.next();
			System.out.println(temp.name+", "+temp.age);
		}
	}

}
