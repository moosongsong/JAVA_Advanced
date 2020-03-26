package Practice01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class InputStreamReader_usingStringTokenizer {

	public static void main(String[] args) {
		File file = new File("C:\\bigdataprograming\\data.txt");
		FileReader fr = null;
		BufferedReader br = null;
		StringTokenizer st = null;
		
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr, 1024);
			while(true) {
				String str = br.readLine();
				
				if(str == null) {
					break;
				}
				
				st = new StringTokenizer(str, ":");
				try {
					if(st.countTokens()!=2) {
						throw new Exception();
					}
					else {
						String temp;
						int age;
						
						while(st.hasMoreElements()) {
							temp = st.nextToken();
							age = Integer.valueOf(st.nextToken());
							System.out.println("Tokenizer:" +temp +", "+age);
						}
					}
				} catch (NumberFormatException e) {
					System.out.println("데이터 변환에 문제");
				} catch (Exception e) {
					System.out.println("String has problem.");
				}
				
				System.out.println("original String : "+str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}