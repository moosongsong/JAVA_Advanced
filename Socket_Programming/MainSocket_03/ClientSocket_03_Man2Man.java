package MainSocket_03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

//inner클래스
public class ClientSocket_03_Man2Man {
	Socket cSock = null;
	BufferedReader cin = null;
	BufferedReader sin = null;
	PrintWriter sout = null;
	
	class ClientReceiver extends Thread{
		@Override
		public void run() {
			try {
				while(true) {
					String recvMsg = sin.readLine();
					System.out.println(recvMsg);
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						break;
					}
				}
			} catch (Exception e) {
				System.out.println("Client Receiver Fail");
			}
		}
	}
	public void start() {
		Thread t =null;
		try {
			
			cSock = new Socket("192.168.30.23", 9000);
//			cSock = new Socket("127.0.0.1", 9000);
			System.out.println("Connect");
			cin = new BufferedReader(new InputStreamReader(System.in));
			sout = new PrintWriter(new BufferedWriter(new OutputStreamWriter(cSock.getOutputStream())));
			sin = new BufferedReader(new InputStreamReader(cSock.getInputStream()));
			t= new ClientReceiver();
			t.start();
			
			while(true) {
				String msg = cin.readLine();
				sout.println(msg);
				sout.flush();
			}
		} catch (Exception e) {
			System.out.println("Fail");
		} finally {
			t.interrupt();
			try {
				cSock.close();
			} catch (IOException e) {
				System.out.println("Close Failed");
			}
		}
	}
	
	
	public static void main(String [] args) {
		ClientSocket_03_Man2Man c = new ClientSocket_03_Man2Man();
		c.start();//thread start 아니에여
	}
}
