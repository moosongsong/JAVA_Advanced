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
				System.err.println("�������� ������ �ν��ؿ�....");
			}
		}
		System.out.println("�޽��� ���� �����带 �����Ͽ����ϴ�.");
	}
}

public class ChattingClient {

	public static void main(String[] args) {
		///////////////////////�Է�Ȯ�� �۾�/////////////////////////////////////
		if(!((args.length ==1) || (args.length ==2))) {
			System.err.println("�߸��� ��� ����...");
			System.err.println("���� >> java Sender [ip] ��Ʈ��ȣ");
			System.exit(1);//������ ����
		}

		///////////////�Է� ������ ��ȿ�� �˻�/////////////////////////////////////
		int portNum=0;
		int portIndex=0;
		InetAddress ia = InetAddress.getLoopbackAddress();
		if (args.length==2) {
			try {
				ia = InetAddress.getByName(args[0]);
			} catch (UnknownHostException e) {
				System.err.println("ȣ��Ʈ ã�� �� ����.");
				System.exit(2);
			}
			portIndex++;//�ε��� ��ȣ�� 1�� �ٲ�鼭 ��Ʈ��ȣ ������ ����.
		} 

		//////////////��Ʈ�Է�////////////////////////////////////////////////
		try {
			portNum = Integer.parseInt(args[portIndex]);//��Ʈ int ������ ��ȯ
			//��Ʈ ��ȣ ���� üũ
			if((portNum<1)||(portNum>65535)) {
				System.out.println("Wrong Port Number arange...");
				System.out.println("Port Number = 1~65535 can be used...");
				System.exit(3);
			}
		} catch (NumberFormatException e) {//�Ľ��������� ���ܹ߻��� ó��
			System.out.println("Wrong Port Number...");
			System.exit(2);//������ ����
		}		
		Socket socket = null;
		PrintWriter socketwriter = null;
		BufferedReader consolein = null;
		Thread receiveThread = null;
		
		try {
			socket = new Socket(ia, portNum);
			System.out.println(ia.getHostName()+" äƾ������ �����Ͽ����ϴ�.");
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
		System.out.println("���α׷� ����");
	}
}
