package socketReview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Sender {
	
	//접속할 서버와 인수번호를 받아야 한다.
	//java Sender [서버주소] 포트번호
	//들어온 인수가 1개면 포트번호 2개면 서버주소 포트번호
	
	public static void main(String [] args) {
		Socket clientSocket = null;
		//보내기만 하니까
		OutputStream out = null;
		//콘솔에서 문자열로 입력받기
		BufferedReader consolein = null;
		
		///////////////////////입력확인 작업/////////////////////////////////////
		if(!((args.length ==1) || (args.length ==2))) {
			System.err.println("잘못된 명령 행위...");
			System.err.println("사용법 >> java Sender [ip] 포트번호");
			System.exit(1);//비정상 종료
		}
		
		///////////////입력 성공시 유효성 검사/////////////////////////////////////
		int portNum=0;
		int portIndex=0;
		InetAddress ia = InetAddress.getLoopbackAddress();
		if (args.length==2) {
			try {
				ia = InetAddress.getByName(args[0]);
			} catch (UnknownHostException e) {
				System.err.println("호스트 찾을 수 없음.");
				System.exit(2);
			}
			portIndex++;//인덱스 번호가 1로 바뀌면서 포트번호 가지고 오기.
		} 
		
		//////////////포트입력////////////////////////////////////////////////
		try {
			portNum = Integer.parseInt(args[portIndex]);//포트 int 형으로 변환
			//포트 번호 범위 체크
			if((portNum<1)||(portNum>65535)) {
				System.out.println("Wrong Port Number arange...");
				System.out.println("Port Number = 1~65535 can be used...");
				System.exit(3);
			}
		} catch (NumberFormatException e) {//파싱했을때의 예외발생시 처리
			System.out.println("Wrong Port Number...");
			System.exit(2);//비정상 종료
		}
		
		///////////클라이언트 소켓 만들기///////////////////////////////////////
		try {
			clientSocket = new Socket(ia, portNum);//여기서 예외 발생할 수 있음.
			System.out.println(ia +","+portNum+", Connect Success!");
			
			// 밖으로 내보낼 출력 스트림 연결하기. 자기 자신의 출력스트림을 만들어.
			out = clientSocket.getOutputStream();
			//콘솔의 입력 문자 받기위한 리더 생성. 그래서 System.in
			consolein = new BufferedReader(new InputStreamReader(System.in));
			
			
			//
			while(true) {
				//입력한 값들을 모아둘 버퍼 만들기
				StringBuffer strBuffer = new StringBuffer(Common.BUFFER_SIZE);
				
				//우선 값이 시작되었다는 STX 버퍼에 넣기
				strBuffer.append(Common.STX);
				
				//제품 코드 입력받기
				System.out.print("제품코드>>");
				//str에 콘솔에 입력된 문자열 가지고 와서 저장.
				String str = consolein.readLine();
				
				//제품 길이 초과한 경우 잘라서 str에 대문자로 바꾸어 재정리하기.
				if(str.length()>Common.CODE) {
					str = str.substring(0,Common.CODE).toUpperCase();
				}else {
					str = str.substring(0, str.length()).toUpperCase();
				}
				
				//str의 빈자리 공백으로 채우기
				str = String.format("%10s", str);
				strBuffer.append(str);//내보낼 버퍼에 쌓기
				
				//수량 정상정인 입력이 이루어질때까지 계속 받기
				while(true) {
					try {
						System.out.print("제품수량>>");
						str = consolein.readLine();//콘솔창에 있는거 가지고 오기
						int amount = Integer.parseInt(str);//정수형으로 변환, 여기서 예외발생 가능성.
						
						//제품수량 범위 체크. 예외 날림.
						if(amount<0 || amount>9999) {
							System.out.println("범위 오류");
							throw new NumberFormatException();
						}
						
						//str에 4자리 정수형으로 정리하여 재정리하기
						str = String.format("%4d", amount);
						strBuffer.append(str);//내보낼 버퍼에 다시 쌓기
						break;//수량입력 while문 빠져나오기
					} catch (NumberFormatException e) {
						System.out.print("재입력::");
					}
				}
				
				//제품가격의 정상적인 입력이 이루어질때까지 계속 받기
				while(true) {
					try {
						System.out.print("제품가격>>");
						str = consolein.readLine();
						int price = Integer.parseInt(str);
						
						if(price<0 || price>Integer.MAX_VALUE) {
							System.out.println("범위 오류");
							throw new NumberFormatException();
						}
						
						//str에 10자리 정수형으로 정리하여 재정리하기
						str = String.format("%10d", price);
						strBuffer.append(str);//내보낼 버퍼에 다시 쌓기
						break;//제품가격입력 while문 빠져나오기
					} catch (NumberFormatException e) {
						System.out.print("재입력::");
					}
				}
				
				//보낼 메세지가 끝났다는 것을 표시하기위해 ETX를 버퍼에 넣기
				strBuffer.append(Common.ETX);
				
				//버퍼->문자열->바이트로 전환하여 서버로 출력보내기
				out.write(strBuffer.toString().getBytes());
				
				//출력 이후 한번 출력 스트림 비우기
				out.flush();
				
				//입력여부 물어보기
				System.out.print("계속 전송하시겠습니까?([y]/n)>>");
				str = consolein.readLine();//콘솔값 가지고 오기
				
				if(str.trim().toLowerCase().equals("n")) {
					//서버에 송신종료를 나타내는 의미로서 EOT를 전송
					String temp = new StringBuffer().append(Common.EOT).toString();
					out.write(temp.getBytes());
					break;//while문 빠져나가고 시스템은 종료된다.
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				clientSocket.close();
			} catch (IOException e) {
				System.out.println("Close Failed");
			}
		}
	}
}
