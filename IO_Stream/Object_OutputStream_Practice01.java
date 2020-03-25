package 입출력연습;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Object_OutputStream_Practice01 {

	public static void main(String[] args) {
		FileOutputStream fos = null; 
		ObjectOutputStream oos = null;
		
		try {
			fos=new FileOutputStream("C:\\bigdataprograming\\data.txt");
			oos = new ObjectOutputStream(fos);
			
			oos.writeDouble(3.14);
			oos.writeInt(300);
			oos.writeChar('B');
			oos.writeChars("FREE");
			
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
