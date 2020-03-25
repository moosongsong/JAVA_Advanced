package Part_14_Question;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Student{
	public int studentNum;
	public String name;
	public Student(int studentNum, String name) {
		super();
		this.studentNum = studentNum;
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		return studentNum;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (studentNum == ((Student)obj).studentNum);
	}
}

public class Q14_8 {

	public static void main(String[] args) {
		Set<Student> set = new HashSet<Student>();
		
		set.add(new Student(1, "Jin"));
		set.add(new Student(2, "RM"));
		set.add(new Student(1, "Suga"));
		
		
		Iterator<Student> it = set.iterator();
		
		while(it.hasNext()) {
			Student temp = it.next();
			System.out.println(temp.studentNum+", "+temp.name);
		}
	}

}
