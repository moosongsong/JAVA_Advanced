package Practice01;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

class Person{
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		
		if(!this.getClass().getName().equals(obj.getClass().getName())) {
			return false;
		}
		
		Person temp = (Person)obj;
		
		if(this.name!=null) {
			if(!temp.name.equals(temp.name)) {
				return false;
			}
		}
		else {
			if(temp.name == null) {
				return false;
			}
		}
		if(this.age!=temp.age) {
			return false;
		}
		return true;
	}
}

public class OutputStreamWriter_usingStringTokenizer {

	public static void main(String[] args) {
		List <Person> studetns = new ArrayList<Person>();
		studetns.add(new Person("JIN", 29));
		studetns.add(new Person("SUGA", 28));
		studetns.add(new Person ("JK", 24));
		
		File file = new File("C:\\bigdataprograming\\data.txt");
		FileWriter fw = null;//outputStreamWriter 의 기능도 사용 가능!
		PrintWriter pw = null;//sink Stream 이 아니다.
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(file, false);
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);//fw 포장하기
			
			for (Person person : studetns) {
				pw.printf("%s:%d\n", person.getName(), person.getAge());
			}
			pw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}
	}

}
