package socketReview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Sender {
	
	//������ ������ �μ���ȣ�� �޾ƾ� �Ѵ�.
	//java Sender [�����ּ�] ��Ʈ��ȣ
	//���� �μ��� 1���� ��Ʈ��ȣ 2���� �����ּ� ��Ʈ��ȣ
	
	public static void main(String [] args) {
		Socket clientSocket = null;
		//�����⸸ �ϴϱ�
		OutputStream out = null;
		//�ֿܼ��� ���ڿ��� �Է¹ޱ�
		BufferedReader consolein = null;
		
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
		
		///////////Ŭ���̾�Ʈ ���� �����///////////////////////////////////////
		try {
			clientSocket = new Socket(ia, portNum);//���⼭ ���� �߻��� �� ����.
			System.out.println(ia +","+portNum+", Connect Success!");
			
			// ������ ������ ��� ��Ʈ�� �����ϱ�. �ڱ� �ڽ��� ��½�Ʈ���� �����.
			out = clientSocket.getOutputStream();
			//�ܼ��� �Է� ���� �ޱ����� ���� ����. �׷��� System.in
			consolein = new BufferedReader(new InputStreamReader(System.in));
			
			
			//
			while(true) {
				//�Է��� ������ ��Ƶ� ���� �����
				StringBuffer strBuffer = new StringBuffer(Common.BUFFER_SIZE);
				
				//�켱 ���� ���۵Ǿ��ٴ� STX ���ۿ� �ֱ�
				strBuffer.append(Common.STX);
				
				//��ǰ �ڵ� �Է¹ޱ�
				System.out.print("��ǰ�ڵ�>>");
				//str�� �ֿܼ� �Էµ� ���ڿ� ������ �ͼ� ����.
				String str = consolein.readLine();
				
				//��ǰ ���� �ʰ��� ��� �߶� str�� �빮�ڷ� �ٲپ� �������ϱ�.
				if(str.length()>Common.CODE) {
					str = str.substring(0,Common.CODE).toUpperCase();
				}else {
					str = str.substring(0, str.length()).toUpperCase();
				}
				
				//str�� ���ڸ� �������� ä���
				str = String.format("%10s", str);
				strBuffer.append(str);//������ ���ۿ� �ױ�
				
				//���� �������� �Է��� �̷���������� ��� �ޱ�
				while(true) {
					try {
						System.out.print("��ǰ����>>");
						str = consolein.readLine();//�ܼ�â�� �ִ°� ������ ����
						int amount = Integer.parseInt(str);//���������� ��ȯ, ���⼭ ���ܹ߻� ���ɼ�.
						
						//��ǰ���� ���� üũ. ���� ����.
						if(amount<0 || amount>9999) {
							System.out.println("���� ����");
							throw new NumberFormatException();
						}
						
						//str�� 4�ڸ� ���������� �����Ͽ� �������ϱ�
						str = String.format("%4d", amount);
						strBuffer.append(str);//������ ���ۿ� �ٽ� �ױ�
						break;//�����Է� while�� ����������
					} catch (NumberFormatException e) {
						System.out.print("���Է�::");
					}
				}
				
				//��ǰ������ �������� �Է��� �̷���������� ��� �ޱ�
				while(true) {
					try {
						System.out.print("��ǰ����>>");
						str = consolein.readLine();
						int price = Integer.parseInt(str);
						
						if(price<0 || price>Integer.MAX_VALUE) {
							System.out.println("���� ����");
							throw new NumberFormatException();
						}
						
						//str�� 10�ڸ� ���������� �����Ͽ� �������ϱ�
						str = String.format("%10d", price);
						strBuffer.append(str);//������ ���ۿ� �ٽ� �ױ�
						break;//��ǰ�����Է� while�� ����������
					} catch (NumberFormatException e) {
						System.out.print("���Է�::");
					}
				}
				
				//���� �޼����� �����ٴ� ���� ǥ���ϱ����� ETX�� ���ۿ� �ֱ�
				strBuffer.append(Common.ETX);
				
				//����->���ڿ�->����Ʈ�� ��ȯ�Ͽ� ������ ��º�����
				out.write(strBuffer.toString().getBytes());
				
				//��� ���� �ѹ� ��� ��Ʈ�� ����
				out.flush();
				
				//�Է¿��� �����
				System.out.print("��� �����Ͻðڽ��ϱ�?([y]/n)>>");
				str = consolein.readLine();//�ְܼ� ������ ����
				
				if(str.trim().toLowerCase().equals("n")) {
					//������ �۽����Ḧ ��Ÿ���� �ǹ̷μ� EOT�� ����
					String temp = new StringBuffer().append(Common.EOT).toString();
					out.write(temp.getBytes());
					break;//while�� ���������� �ý����� ����ȴ�.
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
