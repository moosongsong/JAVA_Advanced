package 이터레이터제네릭;

class PersonJK{
	private String name;

	public PersonJK(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "PersonJK [name=" + name + "]";
	}
}

public class Generic_Iterator_AppStart {

	public static void main(String[] args) {
		MyCollection <Integer> collection = new MyCollection<Integer>(100);
		collection.add(100);
		collection.add(200);
		collection.add(300);
		
		Generic_Iterator<Integer> it = collection.iterator();
		
		while(it.hasnext()) {
			int value=it.next();
			System.out.println(value);
		}
		
		MyCollection<PersonJK> jk = new MyCollection<PersonJK>(300);
		jk.add(new PersonJK("석진"));
		jk.add(new PersonJK("윤기"));
		jk.add(new PersonJK("태형"));
		
		Generic_Iterator<PersonJK> itJK = jk.iterator();
		while(itJK.hasnext()) {
			PersonJK value = itJK.next();
			System.out.println(value);
		}
	}
}
//moosongsong