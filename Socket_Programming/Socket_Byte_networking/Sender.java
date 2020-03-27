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
		//콘솔에서 입력받기
		BufferedReader consolein = null;
		
		if(!((args.length ==1) || (args.length ==2))) {
			System.err.println("잘못된 명령 행위...");
			System.err.println("사용법 >> java Sender [ip] 포트번호");
			System.exit(1);//비정상 종료
		}
		
		
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
			portIndex++;
		} 
		
		try {
			portNum = Integer.parseInt(args[portIndex]);
			if((portNum<1)||(portNum>65535)) {
				System.out.println("Wrong Port Number arange...");
				System.out.println("Port Number = 1~65535 can be used...");
				System.exit(3);
			}
		} catch (NumberFormatException e) {
			System.out.println("Wrong Port Number...");
			System.exit(2);//비정상 종료
		}
		
		
		try {
			clientSocket = new Socket(ia, portNum);//여기서 예외 발생할 수 있음.
			
			
			System.out.println(ia +","+portNum+", Connect Success!");
			
			out = clientSocket.getOutputStream();
			consolein = new BufferedReader(new InputStreamReader(System.in));
			
			while(true) {
				StringBuffer strBuffer = new StringBuffer(Common.BUFFER_SIZE);
				strBuffer.append(Common.STX);//요렇게 사용해도 돼.
				
				System.out.print("제품코드>>");//10
				String str = consolein.readLine();
				if(str.length()>10) {
					str = str.substring(0,10).toUpperCase();
				}else {
					str = str.substring(0, str.length()).toUpperCase();
				}
				
				str = String.format("%10s", str);//빈자리 공백으로 채우기
				strBuffer.append(str);
				
				while(true) {
					try {
						System.out.print("제품수량>>");//4
						str = consolein.readLine();
						int amount = Integer.parseInt(str);
						
						if(amount<0 || amount>9999) {
							System.out.println("범위 오류");
							throw new NumberFormatException();
						}

						str = String.format("%4d", amount);
						
						strBuffer.append(str);
						break;
					} catch (NumberFormatException e) {
						System.out.print("재입력::");
					}
				}
				
				while(true) {
					try {
						System.out.print("제품가격>>");//10
						str = consolein.readLine();
						int price = Integer.parseInt(str);
						
						if(price<0 || price>Integer.MAX_VALUE) {
							System.out.println("범위 오류");
							throw new NumberFormatException();
						}

						str = String.format("%10d", price);
						
						strBuffer.append(str);
						break;
					} catch (NumberFormatException e) {
						System.out.print("재입력::");
					}
				}
							
				strBuffer.append(Common.ETX);
				out.write(strBuffer.toString().getBytes());
				
				out.flush();
				
				System.out.print("계속 전송하시겠습니까?([y]/n)>>");
				str = consolein.readLine();
				if(str.trim().toLowerCase().equals("n")) {
					//서버에 송신종료를 나타내는 의미로서 EOT를 전송
					String temp = new StringBuffer().append(Common.EOT).toString();
					out.write(temp.getBytes());
					break;
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
