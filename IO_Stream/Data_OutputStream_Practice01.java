package ����¿���;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Data_OutputStream_Practice01 {

	public static void main(String[] args) {
		FileOutputStream fos = null; // ����Ʈ ������ �۾� , �� ����Ʈ ������ ����� �Ѵ�. //file��
		// ���� ���Ͽ� ����Ʈ������ ����ϴ� �ϸ� �Ѵ�.
		DataOutputStream dos = null;
		
		try {
			fos = new FileOutputStream("C:\\bigdataprograming\\data.txt");
			dos = new DataOutputStream(fos);
//			fos.write(65);
//			fos.write(66);
			dos.writeInt(300);
			dos.writeDouble(3.14);
			dos.writeChar('A');
			dos.writeChars("������");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
		} finally {
			try {
//				fos.close();//dos �ȿ� fos �� �ֱ� ������ �Բ� ������.
				dos.close();//Autocloseable �� �����Ǿ� �ִ�.
			} catch (IOException | NullPointerException e) {
				e.printStackTrace();
			}
		}
		
	}

}
