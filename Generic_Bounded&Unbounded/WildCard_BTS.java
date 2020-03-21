import java.util.Arrays;

public class WildCard_BTS {
	
	public static void showListBTS(Course<?>course) {
		Arrays.toString(course.getJin());
	}
	//super
	public static void showListJin(Course<? super Jin>course) {//BTS & JIN 만 받을 수 있다.
		Arrays.toString(course.getJin());
	}
	
	public static void showListRM(Course<? super RM>course) {//BTS & RM 만 받을 수 있다.
		Arrays.toString(course.getJin());
	}
	
	public static void showListRJ(Course<? super RJ>course) {//BTS & RJ & Jin 만 받을 수 있다.
		Arrays.toString(course.getJin());
	}

	public static void main(String[] args) {

		Course<Jin> course = new Course<>("JIN과정", 2);//Jin 타입이 될수 있는 건 다들어감
		
		course.add(new Jin("ff", "rr"));
		course.add(new RJ("fdkf", "dkjfdf", 30));
		course.add(new Jin("ff", "rr"));
		course.add(new Jin("ff", "rr"));
		
		System.out.println(Arrays.toString(course.getJin()));
	}

}
