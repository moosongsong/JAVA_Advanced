class Box<T>{
	T member;
	
	public Box(T member) {
		this.member=member;
	}
	
	public void setMember(T member) {
		this.member=member;
	}
	
	public T getMember() {
		return member;
	}
}

class MyMap<K,V>{//갯수 제한 없음!
	private K key;
	private V value;
	
	public MyMap(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public void setValue(V value) {
		this.value = value;
	}
}

class Person{
	private String name;

	public Person(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

public class Generic_Type_Class_Practic{
	
	public static void main(String[] args) {
		
		//int 는 기본 자료형이므로 객체를 집어넣어야 하는 자리에 넣을 수 없다.
//		Box <int>ii=new Box<int>(1);//따라서 Intrger 또는 Number를 사용하는게 좋다.
		
		//this is class Box Example
		Box b = new Box(new Integer(20));//잠정적으로 인티저 Box로 본다.but 저장은 오브젝트
		System.out.println(b.getMember());//20 
		
		Box<Integer> a = new Box<Integer>(new Integer(30));//입출력 모두 integer로 취급된다.
		System.out.println(a.getMember());//30
		
		Box<Number> c = new Box<Number>(1230);//Number는 Integer로 오버라이딩 되어있어 옳은 타입으로 출력된다.
		System.out.println(a.getMember());//1230
		
		//this is class MyMap Example
		MyMap<String, String> map = new MyMap<String, String>("1번", "김석진");
		System.out.println(map.getKey()+":"+map.getValue());
		
		MyMap map2 = new MyMap("2번", new Person("민윤기"));
		System.out.println(map2.getKey()+":"+map2.getValue());//person class는 오버라이딩 하지 않았고, 
															//캐스팅하지 않았기에 문제가 발생한다.
		System.out.println(map2.getKey()+":"+((Person)map2.getValue()).getName());
											//캐스팅하여 getName 메소드 사용할 수 있게 됨.
											//클래스는 제네릭을 사용했지만 사용은 제네릭으로 사용하지 못했다.
	}
}
//moosongsong
