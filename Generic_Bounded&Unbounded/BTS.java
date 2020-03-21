class BTS {
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

class Jin extends BTS{
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

final class RJ extends Jin{
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
		this.jin = (T[])(new Object[capacity]);
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
		try {
			if(count==jin.length) {
				throw new FullException();
			}
			this.jin[count++]=seok; 
		} catch (CourseException e) {
			System.out.println(e.getMessage());
			e.doExcept(this);
			this.add(seok);
		}finally {//finally가 있는 경우 재귀호출 사용 금지...최대한.
			;
		}
	}
}
//moosongsong0321
