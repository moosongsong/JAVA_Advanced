package 입출력연습;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Data_OutputStream_Practice01 {

	public static void main(String[] args) {
		FileOutputStream fos = null; // 바이트 단위의 작업 , 즉 바이트 단위로 출력을 한다. //file에
		// 오직 파일에 바이트정보를 기록하는 일만 한다.
		DataOutputStream dos = null;
		
		try {
			fos = new FileOutputStream("C:\\bigdataprograming\\data.txt");
			dos = new DataOutputStream(fos);
//			fos.write(65);
//			fos.write(66);
			dos.writeInt(300);
			dos.writeDouble(3.14);
			dos.writeChar('A');
			dos.writeChars("수요일");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
		} finally {
			try {
//				fos.close();//dos 안에 fos 가 있기 때문에 함께 닫힌다.
				dos.close();//Autocloseable 이 구현되어 있다.
			} catch (IOException | NullPointerException e) {
				e.printStackTrace();
			}
		}
		
	}

}
