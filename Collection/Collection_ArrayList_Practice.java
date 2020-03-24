package Part14Main;

import java.util.ArrayList;

class Person{
	private String name;

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==null) {//obj 에 들었니?
			return false;
		}
		if(this.getClass().getName()!=obj.getClass().getName()) {//클래스가 같니?
			return false;
		}
		
		if(this.name==null) {
			if(((Person)obj).name !=null) {//null notnull
				return false;
			}
		}
		else {
			if(((Person)obj).name ==null) {//notnull null
				return false;
			}
		}
		if((this.name).equals(((Person)obj).name)) {
			return true;
		}
		
		return false;
	}
}

public class Collection_ArrayList_Practice {

	public static void main(String[] args) {
		ArrayList <Person>list = new ArrayList<Person>();
		
		list.add(new Person("Jin"));
		list.add(new Person("Suga"));
		list.add(new Person("RM"));
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		if(list.remove(new Person("RM")) ) {
			System.out.println("delete success");
		}
		else {
			System.out.println("Fail");
		}
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}

}
