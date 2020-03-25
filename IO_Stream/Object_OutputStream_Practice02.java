package ����¿���;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class ObectFile2{
	private File file;

	public ObectFile2(String string) throws Exception{
		this.file = new File(string);
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "ObectFile [file=" + file + "]";
	}
	
}

class Person implements Serializable{
	
	private static final long serialVersionUID = 1L;// Ŭ������ ������. �޴� �ʵ� �Ȱ��� ������ ������ �־�� ��.
	
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
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}

public class Object_OutputStream_Practice02 {

	public static void main(String[] args) {
		ObectFile of = null; 
		ObjectOutputStream oos = null;
		
		try {
			of=new ObectFile("C:\\bigdataprograming\\data.txt");
			oos = new ObjectOutputStream(new FileOutputStream(of.getFile()));
			
			oos.writeDouble(3.14);
			oos.writeInt(300);
			oos.writeChar('B');
			oos.writeObject("�ڹٸ� ��ƺ�");
			oos.writeObject(new Person_ob("JIN", 29));
			System.out.println("���Ͼ��� �Ϸ�");
		} catch (FileNotFoundException e) {

		} catch (IOException e) {
		}finally {
			try {
				oos.close();
			} catch (NullPointerException | IOException e) {
				e.printStackTrace();
			}
		}
	}

}
