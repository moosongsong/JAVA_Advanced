package ���׸�;

import java.util.Iterator;

class BTS {//�Ҿƹ���
	//data ��ü
	public static final String TYPE = "TOTAL";
	protected String name;

	public BTS(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

class Jin extends BTS{//�ƹ���
	public static final String TYPE = "JIN";
	protected String nickName;
	
	public Jin(String name, String nickName) {
		super(name);
		this.nickName = nickName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
}

final class RJ extends Jin{//�Ƶ�
	public static final String TYPE = "RJ";
	private int age;
	
	public RJ(String name, String nickName, int age) {
		super(name, nickName);
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

class RM extends BTS{
	public static final String TYPE = "RM";
	private String music;
	
	public RM(String name, String music) {
		super(name);
		this.music = music;
	}

	public String getNickName() {
		return music;
	}

	public void setNickName(String nickName) {
		this.music = nickName;
	}
}

class Course<T extends Jin>{//���� Ÿ���� ����.
	private T[] jin;
	private String courseName;
	private int count;

	@SuppressWarnings("unchecked")
	public Course(String courseName, int capacity) {
		this.jin = (T[])(new Jin[capacity]); //�ٿ���
		this.courseName = courseName;
		this.count = 0;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public void setJin(T[] jin) {
		this.jin = jin;
	}

	public T[] getJin() {
		return jin;
	}

	public String getCourseName() {
		return courseName;
	}

	public int getCount() {
		return count;
	}
	
	public void add(T seok) {
		if(count<jin.length) {
			jin[count++]=seok;
		}
	}
	
	public void showList() {
		for (int i = 0; i < count; i++) {
			T t = jin[i];
//			if(t instanceof RJ){//�� �̷������� ���������� ����ϰԲ��� ���� ����......
//			System.out.println(t.getName);}//�������� ������Ʈ Ÿ��...
			//���� Ÿ���� ���������ν� �ذ��غ� �� �ִ�. �׷��� ������ ������ Jin���� �����ϸ�, RM�� �� �� ����....
			//�׸��� �迭�� ���鶧 �� ��������.....
			System.out.println(t.getName()+","+t.getNickName());
		}
	}

//	public void show() {
//		System.out.println(jin.getName());//��ٿ��� �϶� ���� �Ұ� //��ٿ��� Ÿ�� - ������Ʈ Ÿ��
//		System.out.println(jin.getName());//�ٿ��� - BTS Ÿ��
//		System.out.println(jin.getNickName());
//	}
}
//moosongsong0321