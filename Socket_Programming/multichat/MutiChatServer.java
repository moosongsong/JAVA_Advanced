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
			MutiChatServer.this.foward("ä�ü���>", this.host+"���� ä�ù濡 �����Ͽ����ϴ�.");
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
					System.err.println("Ŭ���̾�Ʈ���� ��������");
					break;
				}
			}
			
			System.out.println("ä�ü��� > "+this.host+"�� ä�ù濡�� �����Ͽ����ϴ�.");
			MutiChatServer.this.remove(this.host);
		}
	}
	
	public void serverStart() {
		try {
			while(true) {
				Socket clientSocket = null;
				//Ŭ���̾�Ʈ �����带 �����ϰ� ����.
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
		System.out.println("ä�� ������ �����Ͽ����ϴ�.");
	}
	
	
	
	public static void main(String[] args) {
		int portNum=0;
		if(args.length !=1) {
			System.err.println("�߸��� ��� ����...");
			System.err.println("���� >> java Receiver [��Ʈ��ȣ]");
			System.exit(1);//������ ����
		}
		
		try {
			portNum = Integer.parseInt(args[0]);//���⼭ ���� ���� �߻���
			//��Ʈ��ȣ Ȯ���ϱ�
			if((portNum<1)||(portNum>65535)) {
				System.out.println("Wrong Port Number arange...");
				System.out.println("Port Number = 1~65535 can be used...");
			}
		} catch (NumberFormatException e) {
			System.out.println("Wrong Port Number...");
			System.exit(2);//������ ����
		}
		
		MutiChatServer app = null;
		try {
			app = new MutiChatServer(portNum);
			System.out.println(portNum);
			app.serverStart();
		} catch (Exception e) {
			System.err.println("���������Ұ�");
		}
	}

}
