package multichat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

class Receiver extends Thread{
	private BufferedReader in;

	public Receiver(BufferedReader in) {
		this.in = in;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				String msg = in.readLine();
				System.out.println(msg);
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					break;
				}
			} catch (IOException e) {
				System.err.println("서버와의 연결이 부실해여....");
			}
		}
		System.out.println("메시지 수신 스레드를 종료하였습니다.");
	}
}

public class ChattingClient {

	public static void main(String[] args) {
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
		Socket socket = null;
		PrintWriter socketwriter = null;
		BufferedReader consolein = null;
		Thread receiveThread = null;
		
		try {
			socket = new Socket(ia, portNum);
			System.out.println(ia.getHostName()+" 채틴서버에 접속하였습니다.");
			consolein = new BufferedReader(new InputStreamReader(System.in), 1024);
			socketwriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()),1024));
			
			receiveThread = new Receiver(new BufferedReader(new InputStreamReader(socket.getInputStream()),1024));
			
			receiveThread.start();
			
			
			while(true) {
				String msg = consolein.readLine();
				socketwriter.println(msg);
				socketwriter.flush();
				if(msg.trim().toLowerCase().equals("bye")) {
					break;
				}
			}
		} catch (Exception e) {
			System.err.println("err");
		} finally {
			receiveThread.interrupt();
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("프로그램 종료");
	}
}
