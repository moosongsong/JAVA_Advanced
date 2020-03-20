public class MyIterator <T>  implements Generic_Iterator<T>{
	
	private MyCollection<T> collection;
	private int cursor;
	
	public MyIterator(MyCollection<T> collection) {
		this.collection = collection;
		cursor = 0;
	}

	public boolean hasnext() {
		return (cursor < collection.getCount());
	}
	
	public T next() {
		return collection.getAt(cursor++);
	}

}
