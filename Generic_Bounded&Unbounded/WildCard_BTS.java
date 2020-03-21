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
	//extends
//	public static void showListJin(Course<? extends Jin>course) {
//		Arrays.toString(course.getJin());
//	}
//	
//	public static void showListRM(Course<? extends RM>course) {
//		Arrays.toString(course.getJin());
//	}
//	
//	public static void showListRJ(Course<? extends RJ>course) {
//		Arrays.toString(course.getJin();
//	}
	
	public static void main(String[] args) {
		Course<BTS> btsCourse = new Course("전체과정", 10);//BTS 타입이 될수 있는 건 다들어감
		Course<Jin> jinCourse = new Course("JIN과정", 10);//Jin 타입이 될수 있는 건 다들어감
		Course<RJ> rjCourse = new Course("RJ 과정", 10);//RJ 타입이 될수 있는 건 다들어감
		Course<RM> rmCourse = new Course("RM과정", 10);//RM 타입이 될수 있는 건 다들어감
		
		//extends 사용시
		showListBTS(btsCourse);
		showListBTS(jinCourse);
		showListBTS(rjCourse);
		showListBTS(rmCourse);//타입제한을 하지 않았기 때문에 다 넘길 수 있다.
		
		showListRJ(rjCourse);//요타입 하나만
		
		showListRM(rmCourse);//요타입 하나만.
		
		//super 사용시
	}

}
