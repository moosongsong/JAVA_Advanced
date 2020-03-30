package Part_18_Question;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Q18_11 {
	
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 5001);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OutputStream od = null;
		
	}

}
