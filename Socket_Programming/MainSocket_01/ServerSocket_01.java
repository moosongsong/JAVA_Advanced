package MainSocket_01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocket_01 {
	public static final String END="BYE";
	public static void main(String[] args) {
		//서버 만드는 순서!
		
		//1. 서버 소켓을 생성하고, 포트에 바인드.
		ServerSocket sSock = null;
		BufferedReader br =null;
		try {
			sSock = new ServerSocket(9000);//숫자 지정하여 포트번호대로 바인딩 하기
			System.out.println("server is connected port 9000");
			
			//2. 클라이언트 접속을 수락하기.
			Socket cSock = sSock.accept();
			InetAddress cInet = cSock.getInetAddress();
			System.out.println(cInet.getHostName()+" connectes.");
			
			//서버와 클라이언트가 통신을 하려면 데이터를 입출력한다는 것이다.
			//즉 스트림이 필요하다.
			//받기
			br = new BufferedReader(new InputStreamReader(cSock.getInputStream()));
			
			//3. 클라이언트와 데이터를 송수신한다.
			while(true) {
				String str = br.readLine();
				//종료조건
				if(str.toUpperCase().equals(END)) {
					break;
				}
				//클라이언드가 연결 끊긴경우
				if(str.toUpperCase().equals("NULL")) {
					System.out.println("Client byebye TT");
					break;
				}
				
				System.out.println(str);
				//최초접속시에 널이 날아올수 있다. 또는 클라이언트가 죽을 경우에도 널이 날아온다.(극히 드묾)
			}
		} catch (Exception e) {
			System.out.println("Fail");
		} finally {
			//4. 서버 소켓을 닫는다.
			try {
				sSock.close();
			} catch (Exception e2) {
				System.out.println("Close Fail");
			}
		}
	}
}
