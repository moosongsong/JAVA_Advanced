package socketReview;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Receiver {
	
	//�޴� ���� �������� ��Ŷ���� Ȯ���� �� �־�� ��.
	
	//������Ʈ�� ����� ��ٸ���
	public static void main(String []args) {
		
		ServerSocket serverSocket = null;
		int portNum=0;
		
		//�ޱ⸸ �ҰŴϱ� InputStream �� �ʿ��ϴ�
		InputStream in = null;
		
		if(args.length !=1) {
			System.err.println("�߸��� ��� ����...");
			System.err.println("���� >> java Receiver [��Ʈ��ȣ]");
			System.exit(1);//������ ����
		}
		
		try {
			portNum = Integer.parseInt(args[0]);
			//��Ʈ��ȣ Ȯ���ϱ�
			if((portNum<1)||(portNum>65535)) {
				System.out.println("Wrong Port Number arange...");
				System.out.println("Port Number = 1~65535 can be used...");
			}
		} catch (NumberFormatException e) {
			System.out.println("Wrong Port Number...");
			System.exit(2);//������ ����
		}
		
		try {
			//���ϸ���� 
			serverSocket = new ServerSocket(portNum);
			System.out.println("Server is connected by using "+portNum+" port...");
			
			
			while(true) {
				Socket clientSocket =null;
				try {
					clientSocket = serverSocket.accept();
					System.out.println(clientSocket.getInetAddress().getHostName()+" is connecting...");
					in = clientSocket.getInputStream();
					//���� ���۸����
					byte[]buffer = new byte [Common.BUFFER_SIZE];
					
					//���� STX, ETX �� ������ �Է��� �߸��Ǿ��ٰ� �ؾ��Ѵ�.
					//���� sender �κ��� EOT�� ���ŵǸ� Sender���� ���� ���� ���ο� ������ ����Ѵ�.
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
							System.err.println("���ۿ����߻�");
							continue;
						}
						
						StringBuffer temp = new StringBuffer(new String(strBuffer));
						
						System.out.println("====�Է°�====");
						temp.delete(0, 1);
						
						System.out.println("��ǰ�ڵ� : "+temp.substring(0,Common.CODE));
						temp.delete(0, Common.CODE);
						
						System.out.println("��ǰ���� : "+temp.substring(0, Common.AMOUNT));
						temp.delete(0, Common.AMOUNT);
						
						System.out.println("��ǰ���� : "+temp.substring(0, Common.PRICE));
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
				//Ŭ���̾�Ʈ ������ Ŭ���̾�Ʈ ������ �ݴ´�.
				serverSocket.close();
			} catch (IOException e) {
				System.out.println("Closed Failed");
			}
		}
	}
}