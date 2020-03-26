package MainSocket_01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocket_01 {
	public static final String END="BYE";
	public static void main(String[] args) {
		//���� ����� ����!
		
		//1. ���� ������ �����ϰ�, ��Ʈ�� ���ε�.
		ServerSocket sSock = null;
		BufferedReader br =null;
		try {
			sSock = new ServerSocket(9000);//���� �����Ͽ� ��Ʈ��ȣ��� ���ε� �ϱ�
			System.out.println("server is connected port 9000");
			
			//2. Ŭ���̾�Ʈ ������ �����ϱ�.
			Socket cSock = sSock.accept();
			InetAddress cInet = cSock.getInetAddress();
			System.out.println(cInet.getHostName()+" connectes.");
			
			//������ Ŭ���̾�Ʈ�� ����� �Ϸ��� �����͸� ������Ѵٴ� ���̴�.
			//�� ��Ʈ���� �ʿ��ϴ�.
			//�ޱ�
			br = new BufferedReader(new InputStreamReader(cSock.getInputStream()));
			
			//3. Ŭ���̾�Ʈ�� �����͸� �ۼ����Ѵ�.
			while(true) {
				String str = br.readLine();
				//��������
				if(str.toUpperCase().equals(END)) {
					break;
				}
				//Ŭ���̾�尡 ���� ������
				if(str.toUpperCase().equals("NULL")) {
					System.out.println("Client byebye TT");
					break;
				}
				
				System.out.println(str);
				//�������ӽÿ� ���� ���ƿü� �ִ�. �Ǵ� Ŭ���̾�Ʈ�� ���� ��쿡�� ���� ���ƿ´�.(���� �干)
			}
		} catch (Exception e) {
			System.out.println("Fail");
		} finally {
			//4. ���� ������ �ݴ´�.
			try {
				sSock.close();
			} catch (Exception e2) {
				System.out.println("Close Fail");
			}
		}
	}
}
