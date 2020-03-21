interface Flyable<T>{//제네릭 인터페이스
}

class Person<T>{//제네릭 클래스
	private T value;
	public Person(T value) {
		super();
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}

class Duck implements Flyable<Integer>{//구현할 때(상속) 클래스 지정.
}

class Student<T extends Number> extends Person<T>{//상한값 지정.
	public Student(T value) {
		super(value);
	}//타입을 클래스 이름뒤에 명시!!!!
}

interface Fightable{}

class Fight<T> implements Fightable{}

class Bird{}

class BlueBird<T> extends Bird{}

///////////////

class Suga{
	public <T> void show(T obj) {//반환형 뒤에 <T>꼭 있어야해!!
	}
}

public class 제네릭 {
	//상속 또는 구현하는 시점에 자료형 지정 가능
	public static void main(String [] argv) {
		//언바운디드 타입 - 제한이 없는 타입 - 미지정시 오브젝트타입으로 들어온다.
		Person<Integer> p =new Person<>(10);//자료형 new에서 생략가능
		Person<Double>d = new Person(new Double(10));//여긴 이렇게 포장해야 한다.
		Person<Number> n =new Person(100.0);//valueof로 포장된다.
		
		//바운디드 타입
//		Student<String> s = new Student("meme");//불가 String은 Number 상속을 하지 않았다.
		Student<Float> s = new Student(1.2);//Number로 상한 타입 제한이 되어있다.
	}
}
