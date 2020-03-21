public class FullException extends CourseException{

	public FullException() {
		super("더 이상 좌석이 없습니다");
	}

	@Override
	public <T> void doExcept(Course<T> course) {
		int newCount = course.getCount()+1;
		System.out.println("좌석이 부족하여 정원을 늘립니다. : "+newCount+"명");
		
		T[] extra = (T[])(new Object[newCount]);
		
		System.arraycopy(course.getJin(), 0, extra, 0, course.getCount());
		course.setJin(extra);
	}
	
}
