package Practice01;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Box implements Serializable{
	//field member
	private static final long serialVersionUID = 1L;
	private int width;
	private int height;
	//constructor
	public Box(int width, int height) {
		this.width = width;
		this.height = height;
	}
	//getter
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	//setter
	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	//field method
	@Override
	public String toString() {
		return "Box [width=" + width + ", height=" + height + "]";
	}
}

public class Serializable_Transient_outputStream {

	public static void main(String[] args) {
		File file = new File("C:\\bigdataprograming\\data.txt");
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			
			oos.writeObject(new Box(2,4));
			oos.writeObject(new Box(20,40));
			oos.writeObject(new Box(200,400));
			oos.flush();
			
			System.out.println("done");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
