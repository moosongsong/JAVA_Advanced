package 입출력연습;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

class ObectFile{
	private File file;

	public ObectFile(String string) {
		super();
		this.file = new File(string);
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "ObectFile [file=" + file + "]";
	}
	
	
}

public class Object_OutputStream_Practice01 {
	

	public static void main(String[] args) {
		ObectFile of = null; 
		ObjectOutputStream oos = null;
		
		try {
			of=new ObectFile("C:\\bigdataprograming\\data.txt");
			oos = new ObjectOutputStream(new FileOutputStream(of.getFile()));
			
			oos.writeDouble(3.14);
			oos.writeInt(300);
			oos.writeChar('B');
			oos.writeObject("wkqk");
			System.out.println("파일쓰기 완료");
		} catch (FileNotFoundException e) {

		} catch (IOException e) {
		}finally {
			try {
				oos.close();
			} catch (NullPointerException | IOException e) {
				e.printStackTrace();
			}
		}
	}

}
