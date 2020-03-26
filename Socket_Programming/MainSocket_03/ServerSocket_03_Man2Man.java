package MainSocket_03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class ServerReceiver implements Runnable{
	BufferedReader sin =null;

	public ServerReceiver(Socket sock) throws IOException {
		this.sin = new BufferedReader(new InputStreamReader(sock.getInputStream()));
	}

	@Override
	public void run() {
		try {
			while(true) {
				String replyMsg = sin.readLine();
				System.out.println(replyMsg);
				try {
					Thread.sleep(1);
				} catch (Exception e) {
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("ServerReceiver Fail");
		}
	}
	//콘솔을 쓰게되면 발생하는 문제점...?
}

public class ServerSocket_03_Man2Man {

	public static void main(String[] args) {
		ServerSocket sSock = null;
		BufferedReader cin = null;
		PrintWriter sout = null;
		Thread receiver =null;
		try {
			sSock = new ServerSocket(9000);
			System.out.println("port 9000");
			Socket cSock= sSock.accept();
			System.out.println(cSock.getInetAddress().getHostName()+"is connected.");
			receiver =new Thread(new ServerReceiver(cSock));
			receiver.start();
			cin = new BufferedReader(new InputStreamReader(System.in));
			sout = new PrintWriter(new BufferedWriter(new OutputStreamWriter(cSock.getOutputStream())));
			
			
			while(true) {
				String sendMsg = cin.readLine();
				sout.println(sendMsg);
				sout.flush();
			}
		} catch (Exception e) {
			System.out.println("Fail");
		} finally {
			receiver.interrupt();
			try {
				sSock.close();
			} catch (IOException e) {
				
			}
		}
	}
}
