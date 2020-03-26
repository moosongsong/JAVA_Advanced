package MainSocket_01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocket_01 {
	public static final String END="BYE";
	public static void main(String[] args) {
		//Ŭ���̾�Ʈ ����� ����
		
		//1. Ŭ���̾�Ʈ ���� ����
		Socket sock = null;
		PrintWriter pw = null;
		BufferedReader br = null;
		try {
			sock = new Socket("127.0.0.1", 9000);
			System.out.println("Connect to 127.0.0.1");
			pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sock.getOutputStream())));
			br = new BufferedReader(new InputStreamReader(System.in));
			//br->pw �ֿܼ��� ������ ������ ������
			
			//2. �������� ��� ����
			while(true) {
				String str = br.readLine();
				pw.println(str);
				pw.flush();
				//��������
				if(str.toUpperCase().equals(END)) {
					break;
				}
				
			}
		} catch (Exception e) {
			System.out.println("Fail");
		} finally {
			//3. ������ �ݱ�
			try {
				sock.close();
			} catch (IOException e) {
				System.out.println("Close Failed");
			}
		}
	}
}