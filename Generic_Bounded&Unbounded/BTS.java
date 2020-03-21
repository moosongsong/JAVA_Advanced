class BTS {//할아버지
	//data 객체
	public static final String TYPE = "TOTAL";
	protected String name;

	public BTS(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

class Jin extends BTS{//아버지
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

final class RJ extends Jin{//아들
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

class Course<T extends Jin>{//상한 타입을 지정.
	private T[] jin;
	private String courseName;
	private int count;

	@SuppressWarnings("unchecked")
	public Course(String courseName, int capacity) {
		this.jin = (T[])(new Jin[capacity]); //바운디드
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
//			if(t instanceof RJ){//뭐 이런식으로 강제적으로 출력하게끔은 수는 있지......
//			System.out.println(t.getName);}//잠정적인 오브젝트 타입...
			//상한 타입을 지정함으로써 해결해볼 수 있다. 그러나 밑으로 내려가 Jin으로 지정하면, RM을 할 수 없다....
			//그리고 배열을 만들때 펑 터질거임.....
			System.out.println(t.getName()+","+t.getNickName());
		}
	}

//	public void show() {
//		System.out.println(jin.getName());//언바운디드 일때 실행 불가 //언바운디드 타입 - 오브젝트 타입
//		System.out.println(jin.getName());//바운디드 - BTS 타입
//		System.out.println(jin.getNickName());
//	}
}
//moosongsong0321
