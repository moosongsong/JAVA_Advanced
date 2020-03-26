package Practice01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReader_ECHO {

	public static void main(String[] args){
		InputStreamReader isr = null;
		BufferedReader in = null;
		try {
			isr = new InputStreamReader(System.in);
			in = new BufferedReader(isr, 1024);
			while(true){
				String line = in.readLine();//라인을 하나 읽어들임.
				System.out.println(line);
				if(line.trim().toLowerCase().equals("bye")) {//echo 중지.
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();//bufferedReader 만 닫으면 내부에 있는 것들도 같이 닫힌다.
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.print("문자하나 입력 :");
		int code = 0;
		try {
			code = System.in.read();//close 되면서 내부에 있는 system.in도 close 되어버린것
			//그래서 읽을 수 없어 오류가 발생한다.
			//한번 닫히면 열 수 있는 방법이 없다.....ㅠㅠ
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(code);
		System.out.println("program Ends");
	}

}
