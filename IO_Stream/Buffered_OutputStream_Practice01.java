package ����¿���;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Buffered_OutputStream_Practice01 {

	public static void main(String[] args) {
		ObjectOutputStream ois = null;
		
		try {
			ois = new ObjectOutputStream(//processing Streadm
					new BufferedOutputStream(
							new FileOutputStream("C:\\bigdataprograming\\data.txt"), 1024));//sink Stream
			
			ois.writeInt(10);
			ois.writeDouble(3.14);
			ois.writeObject("JIN");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();//close �Ҷ� �ڵ����� flush�� �ϰ� �ִ�.
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
