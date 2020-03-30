package socketReview;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Receiver {
	//������Ʈ�� ����� ��ٸ���
	public static void main(String []args) {
		
		ServerSocket serverSocket = null;
		int portNum=0;
		InputStream in = null;//�ޱ⸸ �ҰŴϱ� InputStream �� �ʿ��ϴ�
		
		///////////�Է� Ȯ�� ���//////////////////////////////////////////////////////////
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
		///////////////////////////////////////////////////////////////////////////////
		
		////////////////////////������ ���� �۾�///////////////////////////////////////////
		try {
			//���ϸ���� 
			serverSocket = new ServerSocket(portNum);
			System.out.println("Server is connected by using "+portNum+" port...");
			
			//�Է� ���ν�Ʈ�� ���������� ��� �ޱ�(�پ��� Ŭ���̾�Ʈ����)
			while(true) {
				//Ŭ���̾�Ʈ ���� ���� �ޱ����� �ν��Ͻ� ����
				Socket clientSocket =null;
				try {
					clientSocket = serverSocket.accept();//����
					System.out.println(clientSocket.getInetAddress().getHostName()+" is connecting...");
					
					in = clientSocket.getInputStream();//in:�޴� ��Ʈ��, �������� �޾�? Ŭ���̾�Ʈ �Է� ��Ʈ�� ����.
					
					//���� ���۸����
					byte[]buffer = new byte [Common.BUFFER_SIZE];
					
					//�� Ŭ���̾�Ʈ���� �Է� ��� �ޱ�
					while(true) {
						try {
							in.read(buffer);//���ۿ� �Է� ��Ʈ���� �ִ� �� �ޱ�
						} catch (SocketException e) {//Ŭ���̾�Ʈ ������ ���� ����� ����ó��. ���� �ٸ� Ŭ���̾�Ʈ ���.
							System.out.println(clientSocket.getInetAddress().getHostName()+" BYE...");
							break;
						}
						
						//����Ʈ ���� ��Ʈ������ �ٲٱ�. ���� �ٷ� ����
						String strBuffer = new String(buffer);
						
						//EOT�� �Է½�Ʈ������ ���°��, ���� ����, ���ο� Ŭ���̾�Ʈ ���.
						if(Common.isEOT(strBuffer)) {
							System.out.println(clientSocket.getInetAddress().getHostName()+" BYE...");
							break;
						}
						
						//STX, ETX�� �Է½�Ʈ���� ���� ���, �ٽ� �Է¹ޱ�.
						if(Common.isValidate(strBuffer)) {
							System.err.println("���ۿ����߻�");
							continue;
						}
						
						//////////////////////////////���ڿ� ����//////////////////////////////////////
						
						//��Ʈ������ �ξ��� ����, �������·� �ٲپ� ���ڿ� �����ϱ�.
						StringBuffer temp = new StringBuffer(strBuffer);
						
						//�Է°� ���. ���� ���ڵ��� �������μ� ��� ����ȭ.
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