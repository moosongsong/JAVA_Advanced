package multichat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MutiChatServer {
	public static final int BUFFER_SIZE = 1024;
	
	private Map<String, PrintWriter> clients;
	private ServerSocket serverSocket = null;
//	private int portNumber=0;
	
	public MutiChatServer(int portNumber) throws Exception {
		serverSocket = new ServerSocket(portNumber);
//		this.portNumber = portNumber;
		this.clients = new HashMap<String, PrintWriter>();
	}
	
	public void addClient (Socket clientSocket) throws IOException {
		String host = clientSocket.getInetAddress().getHostName();
		PrintWriter pw = new PrintWriter(
							new BufferedWriter(
									new OutputStreamWriter(
											clientSocket.getOutputStream()), BUFFER_SIZE));
		synchronized (clients) {
			this.clients.put(host, pw);
		}
	}
	
	public void remove(String host) {
		synchronized (clients) {
			this.clients.remove(host);
		}	
	}
	
	public void foward(String host, String message) {
		synchronized (clients) {
			Set<Map.Entry<String, PrintWriter>> entrySet = clients.entrySet();
			for (Map.Entry<String, PrintWriter> entry : entrySet) {
				entry.getValue().println(host + " > " +message);
				entry.getValue().flush();
			}	
		}
	}
	
	class ClientThread extends Thread{
//		private Socket clientSocket;
		private BufferedReader clientReader;
		private String host;
		
		public ClientThread(Socket clientSocket) throws IOException {
//			this.clientSocket = clientSocket;
			this.host = clientSocket.getInetAddress().getHostName();
			this.clientReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()), BUFFER_SIZE);
			MutiChatServer.this.foward("채팅서버>", this.host+"님이 채팅방에 입장하였습니다.");
			MutiChatServer.this.addClient(clientSocket);
		}
		
		
		public void run() {
			while(true) {
				try {
					String reply = this.clientReader.readLine();
					if(reply == null) {
						break;
					}
					MutiChatServer.this.foward(this.host, reply);
					if(reply.trim().toLowerCase().equals("bye")) {
						break;
					}
					System.out.println(reply);
				} catch (IOException e) {
					System.err.println("클라이언트와의 강제종료");
					break;
				}
			}
			
			System.out.println("채팅서버 > "+this.host+"가 채팅방에서 퇴장하였습니다.");
			MutiChatServer.this.remove(this.host);
		}
	}
	
	public void serverStart() {
		try {
			while(true) {
				Socket clientSocket = null;
				//클라이언트 쓰레드를 생성하고 실행.
				try {
					clientSocket = serverSocket.accept();
					Thread ct = new ClientThread(clientSocket);
					ct.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("채팅 서버를 종료하였습니다.");
	}
	
	
	
	public static void main(String[] args) {
		int portNum=0;
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
		
		MutiChatServer app = null;
		try {
			app = new MutiChatServer(portNum);
			System.out.println(portNum);
			app.serverStart();
		} catch (Exception e) {
			System.err.println("서버구동불가");
		}
	}

}
