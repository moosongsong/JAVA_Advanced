class PersonJin<K,V>{
	private K name;
	private V score;
	
	public PersonJin(K name, V score) {
		this.name = name;
		this.score = score;
	}

	public K getName() {
		return name;
	}

	public V getScore() {
		return score;
	}

	public void setName(K name) {
		this.name = name;
	}

	public void setScore(V score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "PersonJin [name=" + name + ", score=" + score + "]";
	}

}

public class Generic_Method_Review {
	
	public static <K,V> PersonJin <K,V> funcJin (K name, V score) {
		PersonJin<K,V> person = new PersonJin <K,V> (name, score);
		return person;
	}
	
	public static void main() {
		PersonJin <String, Integer> j = Generic_Method_Review.<String, Integer>funcJin("김석진", 4);
		System.out.println(j);
	}
}
