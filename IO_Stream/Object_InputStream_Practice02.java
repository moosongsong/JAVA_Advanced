package ����¿���;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Object_InputStream_Practice02 {

	public static void main(String[] args) {
		ObectFile2 of = null;
		ObjectInputStream ois = null;
		
		try {
			of = new ObectFile2("C:\\bigdataprograming\\data.txt");
			ois = new ObjectInputStream(new FileInputStream(of.getFile()));
			
			double d = ois.readDouble();
			int i = ois.readInt();
			char c = ois.readChar();
			Object ob = ois.readObject();
			Person_ob person = (Person_ob)ois.readObject();
			
			System.out.println(d);
			System.out.println(i);
			System.out.println(c);
			System.out.println(ob);
			System.out.println(person.getName()+":"+person.getAge());

		} catch (Exception e) {

		}finally {
			try {
				ois.close();
			} catch (NullPointerException | IOException e) {
				e.printStackTrace();
			}
		}
	}

}
