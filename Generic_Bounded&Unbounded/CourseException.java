public abstract class CourseException extends Exception{//씨리얼 버전 UID를 익셉션이 사용하는데, 그것때문에 warning.
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CourseException(String name) {
		super(name);
	}
	public abstract<T> void doExcept(Course <T> course);
	
}
