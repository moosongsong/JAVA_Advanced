package ���ͷ��������׸�;

public class MyCollection<T> implements Generic_Collection <T>{
	private T[] base;//Ÿ���� �������� ����
	private int count;
	
	public MyCollection(int capacity) {
		base = (T[])(new Object[capacity]);//���� ���⼭ ĳ����!!!!
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
