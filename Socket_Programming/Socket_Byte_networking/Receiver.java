import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Receiver {
	//서버포트를 만들고 기다리기
	public static void main(String []args) {
		
		ServerSocket serverSocket = null;
		int portNum=0;
		InputStream in = null;//받기만 할거니까 InputStream 만 필요하다
		
		///////////입력 확인 잡업//////////////////////////////////////////////////////////
		if(args.length !=1) {
			System.err.println("잘못된 명령 행위...");
			System.err.println("사용법 >> java Receiver [포트번호]");
			System.exit(1);//비정상 종료
		}
		
		try {
			portNum = Integer.parseInt(args[0]);//여기서 숫자 오류 발생함
			//포트번호 확인하기
			if((portNum<1)||(portNum>65535)) {
				System.out.println("Wrong Port Number arange...");
				System.out.println("Port Number = 1~65535 can be used...");
			}
		} catch (NumberFormatException e) {
			System.out.println("Wrong Port Number...");
			System.exit(2);//비정상 종료
		}
		///////////////////////////////////////////////////////////////////////////////
		
		////////////////////////서버측 소켓 작업///////////////////////////////////////////
		try {
			//소켓만들기 
			serverSocket = new ServerSocket(portNum);
			System.out.println("Server is connected by using "+portNum+" port...");
			
			//입력 메인스트림 종료전까지 계속 받기(다양한 클라이언트들을)
			while(true) {
				//클라이언트 소켓 승인 받기위한 인스턴스 생성
				Socket clientSocket =null;
				try {
					clientSocket = serverSocket.accept();//승인
					System.out.println(clientSocket.getInetAddress().getHostName()+" is connecting...");
					
					in = clientSocket.getInputStream();//in:받는 스트림, 누구한테 받아? 클라이언트 입력 스트림 연결.
					
					//받을 버퍼만들기
					byte[]buffer = new byte [Common.BUFFER_SIZE];
					
					//한 클라이언트에게 입력 계속 받기
					while(true) {
						try {
							in.read(buffer);//버퍼에 입력 스트림에 있는 값 받기
						} catch (SocketException e) {//클라이언트 측에서 강제 종료시 예외처리. 이후 다른 클라이언트 대기.
							System.out.println(clientSocket.getInetAddress().getHostName()+" BYE...");
							break;
						}
						
						//바이트 버퍼 스트링으로 바꾸기. 쉽게 다룰 목적
						String strBuffer = new String(buffer);
						
						//EOT가 입력스트림으로 들어온경우, 연결 끊고, 새로운 클라이언트 대기.
						if(Common.isEOT(strBuffer)) {
							System.out.println(clientSocket.getInetAddress().getHostName()+" BYE...");
							break;
						}
						
						//STX, ETX가 입력스트림에 없는 경우, 다시 입력받기.
						if(Common.isValidate(strBuffer)) {
							System.err.println("전송오류발생");
							continue;
						}
						
						//////////////////////////////문자열 수정//////////////////////////////////////
						
						//스트링으로 두었던 버퍼, 버퍼형태로 바꾸어 문자열 수정하기.
						StringBuffer temp = new StringBuffer(strBuffer);
						
						//입력값 출력. 앞의 문자들을 지움으로서 출력 간략화.
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
