package 입출력연습;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class File_InputStream_Practice01 {

	public static void main(String[] args) {
		File f = null;//읽을 파일
		FileInputStream fis = null;//읽을 스트림,바이트 단위로 읽기
		DataInputStream dis = null;//
		//dis가 요청을 하면, 4바이트를 보내줘 하면 붙여서 정수값을 만든다.
		try {
			f=new File("C:\\bigdataprograming\\data.txt");
			fis = new FileInputStream(f);
			dis = new DataInputStream(fis);
			int i = dis.readInt();
			double d = dis.readDouble();
			char c = dis.readChar();
//			String str = dis.readLine();
			//CP949
//			CharSet
			byte[]sr = new byte[100];
			dis.read(sr);
			
			System.out.println(i);
			System.out.println(d);
			System.out.println(c);
//			System.out.println(str);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
	}

}
