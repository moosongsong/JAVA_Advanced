package ����¿���;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class File_InputStream_Practice01 {

	public static void main(String[] args) {
		File f = null;//���� ����
		FileInputStream fis = null;//���� ��Ʈ��,����Ʈ ������ �б�
		DataInputStream dis = null;//
		//dis�� ��û�� �ϸ�, 4����Ʈ�� ������ �ϸ� �ٿ��� �������� �����.
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
