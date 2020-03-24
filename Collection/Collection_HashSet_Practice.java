package Part14Main;

import java.util.HashSet;
import java.util.Iterator;

class Bear{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Bear(String name) {
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
			if(((Bear)obj).name == null) {
				return false;
			}
		}
		else {
			if(((Bear)obj).name != null) {
				return false;
			}
		}
		if(this.name.equals(((Bear)obj).name)) {
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

public class Collection_HashSet_Practice {

	public static void main(String[] args) {
		
		HashSet<Bear> hs = new HashSet<>();
		hs.add(new Bear("JIN"));
		hs.add(new Bear("RM"));
		hs.add(new Bear("JK"));
		hs.add(new Bear("JK"));
		
		Iterator<Bear> it = hs.iterator();
		
		while(it.hasNext()) {
			Bear b = it.next();
			System.out.println(b);
		}
	}

}
