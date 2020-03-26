package networking_inJAVA;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class IP_InetAddress_Practice01 {
	public static void main(String [] args) {
		
		InetAddress ia = InetAddress.getLoopbackAddress();//자기자신.
		System.out.println(ia.getHostAddress());
		System.out.println(ia.getHostName());
		
		try {
			InetAddress iia = InetAddress.getByName("www.google.com");
			System.out.println(iia.getHostAddress());
			System.out.println(Arrays.toString(iia.getAddress()));//byte 배열로 가지고 오기.
			//ip주소는 unsigned 이기 때문에 음수로 나온다 따라서 Byte.toUnsignedInt를 사용하는 것이 좋다.
			byte[]ad = iia.getAddress();
			
			for (int i = 0; i < ad.length; i++) {
				if(i>0) {
					System.out.print(".");
				}
				System.out.print(Byte.toUnsignedInt(ad[i]));
			}
		} catch (UnknownHostException e) {
			System.out.println("cannot find...");
		}
		System.out.println("");
		System.out.println("==naver ip address==");
		InetAddress[] ias;
		try {
			ias = InetAddress.getAllByName(("www.naver.com"));
			for (int i = 0; i < ias.length; i++) {
				System.out.println(ias[i].getHostAddress());
			}
		} catch (UnknownHostException e) {
			
		}
		
		
		
	}
}
