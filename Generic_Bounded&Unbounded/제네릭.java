package ���׸�;
interface Flyable<T>{//���׸� �������̽�
}

class Person<T>{//���׸� Ŭ����
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

class Duck implements Flyable<Integer>{//������ ��(���) Ŭ���� ����.
}

class Student<T extends Number> extends Person<T>{//���Ѱ� ����.
	public Student(T value) {
		super(value);
	}//Ÿ���� Ŭ���� �̸��ڿ� ���!!!!
}

interface Fightable{}

class Fight<T> implements Fightable{}

class Bird{}

class BlueBird<T> extends Bird{}

///////////////

class Suga{
	public <T> void show(T obj) {//��ȯ�� �ڿ� <T>�� �־����!!
	}
}

public class ���׸� {
	//��� �Ǵ� �����ϴ� ������ �ڷ��� ���� ����
	public static void main(String [] argv) {
		//��ٿ��� Ÿ�� - ������ ���� Ÿ�� - �������� ������ƮŸ������ ���´�.
		Person<Integer> p =new Person<>(10);//�ڷ��� new���� ��������
		Person<Double>d = new Person(new Double(10));//���� �̷��� �����ؾ� �Ѵ�.
		Person<Number> n =new Person(100.0);//valueof�� ����ȴ�.
		
		//�ٿ��� Ÿ��
//		Student<String> s = new Student("meme");//�Ұ� String�� Number ����� ���� �ʾҴ�.
		Student<Float> s = new Student(1.2);//Number�� ���� Ÿ�� ������ �Ǿ��ִ�.
	}
}
