package 제네릭;
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

	@Override
	public String toString() {
		return "BTS [name=" + name + "]";
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

	@Override
	public String toString() {
		return "Jin [name=" +super.name +", nickName=" + nickName + "]";
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

	@Override
	public String toString() {
		return "RJ [name=" +super.name +", [nickName=" +super.nickName +", " + age + "]";
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
	
	@Override
	public String toString() {
		return "RM [name=" +super.name +", music=" + music + "]";
	}
}

class Course<T>{
	private T[] jin;
	private String courseName;
	private int count;

	@SuppressWarnings("unchecked")
	public Course(String courseName, int capacity) {
		this.jin = (T[])(new Object[capacity]); //바운디드
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
	
	public <K extends Jin>void add(K seok) {
		if(count<jin.length) {
			System.out.println(seok.getName());//과연 안전한 방법인가.... 고려 요망
			jin[count++]=(T)seok; //들어오기는 Jin 타입으로 들어온다.//잠정적으로 Jin타입이어서 getName()도 가능
			//결국은 여기서 명시적으로 T타입으로 바꾸어야 하고, 결국은 잠정적 오브젝트 타입이다.
		}
	}
	
//	private <K extends Jin> void show(K obj) {
//		System.out.println(obj.getName()+", "+obj.getNickName());
//	}//순수한 클래스의 역할만 수행하도록 하자
	
//	public void showList() {
//	}//외부에서 출력문을 만들어야 한다.
}
//moosongsong0321
