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
		//클라이언트 만드는 순서
		
		//1. 클라이언트 소켓 생성
		Socket sock = null;
		PrintWriter pw = null;
		BufferedReader br = null;
		try {
			sock = new Socket("127.0.0.1", 9000);
			System.out.println("Connect to 127.0.0.1");
			pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sock.getOutputStream())));
			br = new BufferedReader(new InputStreamReader(System.in));
			//br->pw 콘솔에서 받은거 서버로 보내기
			
			//2. 서버와의 통신 수행
			while(true) {
				String str = br.readLine();
				pw.println(str);
				pw.flush();
				//종료조건
				if(str.toUpperCase().equals(END)) {
					break;
				}
				
			}
		} catch (Exception e) {
			System.out.println("Fail");
		} finally {
			//3. 소켓을 닫기
			try {
				sock.close();
			} catch (IOException e) {
				System.out.println("Close Failed");
			}
		}
	}
}