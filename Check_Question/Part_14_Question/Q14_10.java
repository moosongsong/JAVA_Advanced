package Part_14_Question;

import java.util.TreeSet;

class Student30 implements Comparable<Student30>{
	public String id;
	public int score;
	public Student30(String id, int score) {
		super();
		this.id = id;
		this.score = score;
	}
	
	@Override
	public int compareTo(Student30 o) {
		if(this.score>o.score) {
			return 1;
		}
		else if(this.score<o.score) {
			return -1;
		}
		return 0;
	}
}

public class Q14_10 {
	public static void main(String [] args) {
		TreeSet<Student30>treeSet = new TreeSet<>();
		treeSet.add(new Student30("blue",96));
		treeSet.add(new Student30("hong",86));
		treeSet.add(new Student30("whitr",92));
		
		Student30 student = treeSet.last();
		System.out.println("최고점수:"+student.score);
		System.out.println("최고점수를 받은 아이디:"+student.id);
	}
}
