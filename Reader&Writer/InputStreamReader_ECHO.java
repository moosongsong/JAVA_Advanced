package Practice01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReader_ECHO {

	public static void main(String[] args){
		InputStreamReader isr = null;
		BufferedReader in = null;
		try {
			isr = new InputStreamReader(System.in);
			in = new BufferedReader(isr, 1024);
			while(true){
				String line = in.readLine();//������ �ϳ� �о����.
				System.out.println(line);
				if(line.trim().toLowerCase().equals("bye")) {//echo ����.
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();//bufferedReader �� ������ ���ο� �ִ� �͵鵵 ���� ������.
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.print("�����ϳ� �Է� :");
		int code = 0;
		try {
			code = System.in.read();//close �Ǹ鼭 ���ο� �ִ� system.in�� close �Ǿ������
			//�׷��� ���� �� ���� ������ �߻��Ѵ�.
			//�ѹ� ������ �� �� �ִ� ����� ����.....�Ф�
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(code);
		System.out.println("program Ends");
	}

}
