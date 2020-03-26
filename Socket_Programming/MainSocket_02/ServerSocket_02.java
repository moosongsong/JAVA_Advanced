package MainSocket_02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocket_02 {

	public static void main(String[] args) {
		ServerSocket sSock = null;
		BufferedReader cbr = null;
		BufferedReader sbr = null;
		PrintWriter pw = null;
		
		try {
			sSock = new ServerSocket(9000);
			System.out.println("9000�� ��Ʈ�� Ŭ���̾�Ʈ �����...");
			cbr = new BufferedReader(new InputStreamReader(System.in));

			Socket cSock = sSock.accept();
			InetAddress ia = cSock.getInetAddress();
			System.out.println(ia.getHostName()+"Connect!");
			sbr = new BufferedReader(new InputStreamReader(cSock.getInputStream()));
			pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(cSock.getOutputStream())));
			
			while(true) {
				String str = sbr.readLine();
				
				//��������
				if(str.toUpperCase().equals("BYE")) {
					break;
				}
				
				System.out.println("ȸ�� �޽���>>"+str);
				System.out.print("���۸޽��� >>");
				String sendStr = cbr.readLine();
				
				pw.println(sendStr);
				pw.flush();
			}
		} catch (Exception e) {
			System.out.println("Fail");
			e.printStackTrace();
		} finally {
			try {
				sSock.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
		}
	}

}
