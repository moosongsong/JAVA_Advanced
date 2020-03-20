package 병원제네릭구현;

public class AnimalHospital<T> extends Hospital<T>{
	private T[] rooms=null;
	private  int count;
	
	public AnimalHospital(int capacity) {
		super("Animal Hospital");
		rooms = (T[])(new Object[capacity]);
		count = 0;
	}

	@Override
	public T treat(T obj) {
		System.out.println(name + " is Treating "+obj);
		if(count<rooms.length) {
			rooms[count++]=obj;
			return obj;
		}
		return null;
	}

	public int getCount() {
		return count;
	}

	@Override
	public String toString() {
		return "AnimalHospital [count=" + count + "]";
	}
	
	public void showList() {
		for (int i = 0; i < count; i++) {
			System.out.println(rooms[i]+" is here.");
		}
	}
	
}
