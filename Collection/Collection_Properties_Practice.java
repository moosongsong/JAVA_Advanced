package Part14Main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class Collection_Properties_Practice {

	public static void main(String[] args) {
		Properties config = new Properties();
		FileReader fr = null;
		try {
			fr = new FileReader("data1.txt");
			config.load(fr);
			@SuppressWarnings("unchecked")
			Enumeration<String>names = (Enumeration<String>)config.propertyNames();
			
			while(names.hasMoreElements()) {
				String key = (String)names.nextElement();
				System.out.println(key+" : "+config.getProperty(key));
			}
		} catch (FileNotFoundException e) {
			System.out.println("������ ������ ã�� �� �����ϴ�.");
		} catch (IOException e) {
			System.out.println("������ �д� ���� ������ �߻���.");
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				
			}
		}
	}

}
