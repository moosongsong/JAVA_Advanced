package socketReview;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Receiver {
	
	//받는 쪽은 정상적인 패킷인지 확인할 수 있어야 함.
	
	//서버포트를 만들고 기다리기
	public static void main(String []args) {
		
		ServerSocket serverSocket = null;
		int portNum=0;
		
		//받기만 할거니까 InputStream 만 필요하다
		InputStream in = null;
		
		if(args.length !=1) {
			System.err.println("잘못된 명령 행위...");
			System.err.println("사용법 >> java Receiver [포트번호]");
			System.exit(1);//비정상 종료
		}
		
		try {
			portNum = Integer.parseInt(args[0]);
			//포트번호 확인하기
			if((portNum<1)||(portNum>65535)) {
				System.out.println("Wrong Port Number arange...");
				System.out.println("Port Number = 1~65535 can be used...");
			}
		} catch (NumberFormatException e) {
			System.out.println("Wrong Port Number...");
			System.exit(2);//비정상 종료
		}
		
		try {
			//소켓만들기 
			serverSocket = new ServerSocket(portNum);
			System.out.println("Server is connected by using "+portNum+" port...");
			
			
			while(true) {
				Socket clientSocket =null;
				try {
					clientSocket = serverSocket.accept();
					System.out.println(clientSocket.getInetAddress().getHostName()+" is connecting...");
					in = clientSocket.getInputStream();
					//받을 버퍼만들기
					byte[]buffer = new byte [Common.BUFFER_SIZE];
					
					//만약 STX, ETX 가 없으면 입력이 잘못되었다고 해야한다.
					//만약 sender 로부터 EOT가 수신되면 Sender와의 수신 종료 새로운 접속을 대기한다.
					while(true) {
						try {
							in.read(buffer);
						} catch (SocketException e) {
							System.out.println(clientSocket.getInetAddress().getHostName()+" BYE...");
							break;
						}
						
						String strBuffer = new String(buffer);
						
						if(Common.isEOT(strBuffer)) {
							System.out.println(clientSocket.getInetAddress().getHostName()+" BYE...");
							break;
						}
						
						if(Common.isValidate(strBuffer)) {
							System.err.println("전송오류발생");
							continue;
						}
						
						StringBuffer temp = new StringBuffer(new String(strBuffer));
						
						System.out.println("====입력값====");
						temp.delete(0, 1);
						
						System.out.println("제품코드 : "+temp.substring(0,Common.CODE));
						temp.delete(0, Common.CODE);
						
						System.out.println("제품수량 : "+temp.substring(0, Common.AMOUNT));
						temp.delete(0, Common.AMOUNT);
						
						System.out.println("제품가격 : "+temp.substring(0, Common.PRICE));
						temp.delete(0, Common.PRICE);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				//클라이언트 소켓은 클라이언트 측에서 닫는다.
				serverSocket.close();
			} catch (IOException e) {
				System.out.println("Closed Failed");
			}
		}
	}
}