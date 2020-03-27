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
		//�ֿܼ��� �Է¹ޱ�
		BufferedReader consolein = null;
		
		if(!((args.length ==1) || (args.length ==2))) {
			System.err.println("�߸��� ��� ����...");
			System.err.println("���� >> java Sender [ip] ��Ʈ��ȣ");
			System.exit(1);//������ ����
		}
		
		
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
			System.exit(2);//������ ����
		}
		
		
		try {
			clientSocket = new Socket(ia, portNum);//���⼭ ���� �߻��� �� ����.
			
			
			System.out.println(ia +","+portNum+", Connect Success!");
			
			out = clientSocket.getOutputStream();
			consolein = new BufferedReader(new InputStreamReader(System.in));
			
			while(true) {
				StringBuffer strBuffer = new StringBuffer(Common.BUFFER_SIZE);
				strBuffer.append(Common.STX);//�䷸�� ����ص� ��.
				
				System.out.print("��ǰ�ڵ�>>");//10
				String str = consolein.readLine();
				if(str.length()>10) {
					str = str.substring(0,10).toUpperCase();
				}else {
					str = str.substring(0, str.length()).toUpperCase();
				}
				
				str = String.format("%10s", str);//���ڸ� �������� ä���
				strBuffer.append(str);
				
				while(true) {
					try {
						System.out.print("��ǰ����>>");//4
						str = consolein.readLine();
						int amount = Integer.parseInt(str);
						
						if(amount<0 || amount>9999) {
							System.out.println("���� ����");
							throw new NumberFormatException();
						}

						str = String.format("%4d", amount);
						
						strBuffer.append(str);
						break;
					} catch (NumberFormatException e) {
						System.out.print("���Է�::");
					}
				}
				
				while(true) {
					try {
						System.out.print("��ǰ����>>");//10
						str = consolein.readLine();
						int price = Integer.parseInt(str);
						
						if(price<0 || price>Integer.MAX_VALUE) {
							System.out.println("���� ����");
							throw new NumberFormatException();
						}

						str = String.format("%10d", price);
						
						strBuffer.append(str);
						break;
					} catch (NumberFormatException e) {
						System.out.print("���Է�::");
					}
				}
							
				strBuffer.append(Common.ETX);
				out.write(strBuffer.toString().getBytes());
				
				out.flush();
				
				System.out.print("��� �����Ͻðڽ��ϱ�?([y]/n)>>");
				str = consolein.readLine();
				if(str.trim().toLowerCase().equals("n")) {
					//������ �۽����Ḧ ��Ÿ���� �ǹ̷μ� EOT�� ����
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
