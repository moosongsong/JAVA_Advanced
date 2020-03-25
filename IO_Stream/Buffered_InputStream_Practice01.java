package 입출력연습;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class Buffered_InputStream_Practice01 {

	public static void main(String[] args) {
		ObjectInputStream ois = null;
		Buffered_InputStream_Pratice02_Main bis = null;//
		
		try {
			bis = new Buffered_InputStream_Pratice02_Main(//
					new FileInputStream("C:\\bigdataprograming\\data.txt"), 512);//
			
//			ois = new ObjectInputStream(
//					new BufferedInputStream(
//							new FileInputStream("C:\\bigdataprograming\\data.txt"), 512));
			
			ois = new ObjectInputStream(bis);//
			
			byte [] buf = bis.getBuffer();//
			System.out.println(Arrays.toString(buf));//
			
			int i = ois.readInt();
			double d = ois.readDouble();
			String s=(String)ois.readObject();
			
			System.out.println(i);
			System.out.println(d);
			System.out.println(s);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
