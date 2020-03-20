package 이터레이터제네릭;

public class MyCollection<T> implements Generic_Collection <T>{
	private T[] base;//타입이 정해지지 않음
	private int count;
	
	public MyCollection(int capacity) {
		base = (T[])(new Object[capacity]);//따라서 여기서 캐스팅!!!!
		count = 0;
	}
	
	public int getCount() {
		return count;
	}

	public T getAt(int index) {
		return base[index];
	}

	public void add(T value) {
		base[count++]=value;
	}

	public Generic_Iterator<T> iterator() {
		return new MyIterator<T>(this);
	}
}
