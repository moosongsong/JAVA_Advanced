package Practice01;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Serializable_Transient_inputStream {

	public static void main(String[] args) {
		File file = new File("C:\\bigdataprograming\\data.txt");
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			Object obj = null;
			
			while(true) {
				
				try {
					obj = ois.readObject();
					
					if(!(obj instanceof Box)) {
						System.out.println("this is not box");
					}
					else {
						System.out.println((Box)obj);
					}
				} catch (EOFException e) {
					break;
				}  
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
