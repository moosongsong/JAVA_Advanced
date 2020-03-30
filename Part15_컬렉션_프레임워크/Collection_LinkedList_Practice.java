package Part14Main;

import java.util.Iterator;
import java.util.LinkedList;

class Person12{
	private String name;

	public Person12(String name) {
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
			if(((Person12)obj).name !=null) {//null notnull
				return false;
			}
		}
		else {
			if(((Person12)obj).name ==null) {//notnull null
				return false;
			}
		}
		if((this.name).equals(((Person12)obj).name)) {
			return true;
		}
		
		return false;
	}
}

public class Collection_LinkedList_Practice {
	public static void main(String[] args) {
		LinkedList <Person12>list = new LinkedList<Person12>();
		
		list.add(new Person12("TaeTae"));
		list.add(new Person12("Jimin"));
		list.add(new Person12("JungKook"));
		
		Iterator<Person12>it = list.descendingIterator();
		
		while(it.hasNext()) {// 이터레이터 사용하기
			System.out.println(it.next());
		}
		
//		list.clear();
		
		while(!list.isEmpty()) {
			System.out.println(list.remove(0)+" delete");
		}
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
	

}
