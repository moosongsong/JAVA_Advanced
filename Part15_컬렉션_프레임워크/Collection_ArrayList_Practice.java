package Part14Main;

import java.util.ArrayList;

class Bear2{
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Bear2(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Bear [name=" + name + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==null) {
			return false;
		}
		if(!(this.getClass().getName().equals(obj.getClass().getName()))) {
			return false;
		}
		if(this.name!=null) {
			if(((Bear2)obj).name == null) {
				return false;
			}
		}
		else {
			if(((Bear2)obj).name != null) {
				return false;
			}
		}
		if(this.name.equals(((Bear2)obj).name)) {
			return true;
		}
		return false;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int code = 1;
		code =prime * code + (this.name==null? 0: this.name.hashCode());
		return code;
	}
	
}
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
			if(((Bear2)obj).getName() !=null) {//null notnull
				return false;
			}
		}
		else {
			if(((Bear2)obj).getName() ==null) {//notnull null
				return false;
			}
		}
		if((this.name).equals(((Bear2)obj).getName())) {
			return true;
		}
		
		return false;
	}
}

public class Collection_ArrayList_Practice {

	public static void main(String[] args) {
		ArrayList <Bear2>list = new ArrayList<Bear2>();
		
		list.add(new Bear2("Jin"));
		list.add(new Bear2("Suga"));
		list.add(new Bear2("RM"));
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		if(list.remove(new Bear2("RM")) ) {
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
