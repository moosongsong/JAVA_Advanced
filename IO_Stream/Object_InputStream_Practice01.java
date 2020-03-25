package 입출력연습;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Object_InputStream_Practice01 {

	public static void main(String[] args) {
		FileInputStream fis = null; 
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream("C:\\bigdataprograming\\data.txt");
			ois = new ObjectInputStream(fis);
			
			double d = ois.readDouble();
			int i = ois.readInt();
			char c = ois.readChar();
			String str = ois.readLine();
			
			System.out.println(d);
			System.out.println(i);
			System.out.println(c);
			System.out.println(str);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
