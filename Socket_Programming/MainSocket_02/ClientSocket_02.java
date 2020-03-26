package MainSocket_02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocket_02 {

	public static void main(String[] args) {
		Socket cSock =null;
		BufferedReader cin = null;
		PrintWriter sout = null;
		BufferedReader sin = null;
		
		try {
			cSock = new Socket("127.0.0.1", 9000);
			System.out.println("Socket connected 127.0.0.1!");
			
			cin = new BufferedReader(new InputStreamReader(System.in));
			sin = new BufferedReader(new InputStreamReader(cSock.getInputStream()));
			sout = new PrintWriter(new BufferedWriter(new OutputStreamWriter(cSock.getOutputStream())));
			
			while(true) {
				System.out.print("전송 메시지 >>");
				String str = cin.readLine();
				sout.println(str);
				sout.flush();
				
				//종료조건
				if(str.toUpperCase().equals("BYE")) {
					break;
				}
				
				String reply = sin.readLine();
				System.out.println("회신 >> "+reply);
				
				//종료조건
				if(reply.toUpperCase().equals("BYE")) {
					break;
				}
			}
			
		} catch (Exception e) {
			System.out.println("Fail");
		} finally {
			try {
				cSock.close();
			} catch (IOException e) {
				System.out.println("Close Failed");
			}
		}
	}

}
