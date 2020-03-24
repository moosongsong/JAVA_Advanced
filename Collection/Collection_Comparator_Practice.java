package Part14Main;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

class Person3{
	private String name;
	private int kor;
	
	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public Person3(String name, int kor) {
		this.name = name;
		this.kor = kor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	@Override
	public String toString() {
		return "Person3 [name=" + name + ", kor=" + kor + "]";
	}

//	@Override
//	public boolean equals(Object obj) {
//		if(obj==null) {//obj 에 들었니?
//			return false;
//		}
//		if(this.getClass().getName()!=obj.getClass().getName()) {//클래스가 같니?
//			return false;
//		}
//		
//		if(this.name==null) {
//			if(((Person3)obj).name !=null) {//null notnull
//				return false;
//			}
//		}
//		else {
//			if(((Person3)obj).name ==null) {//notnull null
//				return false;
//			}
//		}
//		if((this.name).equals(((Person3)obj).name)) {
//			return true;
//		}
//		
//		return false;
//	}
}

class PersonComparator implements Comparator<Person3>{

	@Override
	public int compare(Person3 o1, Person3 o2) {
		return Integer.valueOf(o1.getKor()).compareTo(o2.getKor());
	}
	
}

public class Collection_Comparator_Practice{
	public static void main(String[] args) {
		TreeSet <Person3> ts = new TreeSet<>(new Comparator<Person3>() {
			@Override
			public int compare(Person3 o1, Person3 o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		
		ts.add(new Person3("mm", 30));
		ts.add(new Person3("nn", 30));
		ts.add(new Person3("aa", 30));
		ts.add(new Person3("bb", 30));
		
		for (Person3 person3 : ts) {
			System.out.println(person3);
		}
	}
}
