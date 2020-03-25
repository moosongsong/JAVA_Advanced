package Part_13_Question;

class Pair<K, V>{
	private K key;
	private V value;
	
	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}
	
	public V getValue() {
		return value;
	}
}

class ChildPair <K, V> extends Pair<K,V>{
	public ChildPair(K key, V value) {
		super(key, value);
	}
}

class OtherPair<K, V>{
	private K key;
	private V value;
	
	public OtherPair(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}
	
	public V getValue() {
		return value;
	}
}

class Util{
	public static Integer getValue(Pair pair, String string) {
		if(pair.getKey().equals(string)) {
			return (Integer) pair.getValue();
		}
		return null;
	}
}

public class Q13_4 {

	public static void main(String[] args) {
		Pair<String, Integer> pair = new Pair<String, Integer>("JIN", 29);
		Integer age = Util.getValue(pair, "JIN");
		System.out.println(age);
		
		ChildPair<String, Integer> childPair = new ChildPair<String, Integer>("SUGA", 28);
		Integer childAge = Util.getValue(childPair, "JIMIN");
		System.out.println(childAge);
		
	}

}
