package ����¿���;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class File_OutputStream_Practice01 {

	public static void main(String[] args) {
		File file = null;
//		���� �����
//		file = new File("C:\\bigdataprograming\\data.txt");
//		if(file.exists()) {
//			System.out.println("file exists");
//		}
//		else {
//			System.out.println("file not exists");
//			try {
//				file.createNewFile();
//			} catch (IOException e) {
//				System.out.println("������ �����ϴ�.");
//				e.printStackTrace();
//				System.out.println(file.getName()+" is made.");
//			}
//		}
		
		//�ӽ����� �����
//		try {
//			file = File.createTempFile("temp_", ".tmp", new File("C:\\bigdataprograming"));
//			System.out.println(file.getAbsolutePath()+"�� �����Ͽ����ϴ�.");
//		} catch (IOException e1) {		}
//		
//		//���� ����� ���� ����
//		file.deleteOnExit();
//		
//		//dir �����
//		File dir = null;
//		dir = new File("C:\\bigdataprograming\\backup\\12month");
//		if(dir.exists()) {
//			;
//		}
//		else {
//			dir.mkdirs();
//		}
		
		//10�� �ð� �ɾ������.
//		try {
//			Thread.sleep(10000);
//			
//		}catch (InterruptedException e) {
//		}
		
		
		/////////////////////////////////////////////////////////////////////////
		/*
		 * backup ���丮�� ������ �����ϰ�
		 * backup ������ result.log ������ ����
		 * result.log ������ ������ �������� ���� ��츸 ����
		 */
				
//		File dir2 =null;
//		File file2=null;
//		
//		dir2 = new File("C:\\bigdataprograming\\backup");
//		if(dir2.exists()) {
//			;
//		}
//		else {
//			dir2.mkdirs();
//		}
//		
//		file2 = new File("C:\\bigdataprograming\\backup\\result.log");
//		if(file2.exists()) {
//			;
//		}
//		else {
//			try {
//				file2.createNewFile();
//			} catch (IOException e) {
//				System.out.println("���� ����.");
//			}
//		}
		
//		//Program Files �� �ִ� ���丮 Ȯ���ϱ�
//		File dir = null;
		
//		search(new File("C:\\Program Files"));
		anotherSearch();
		
	}
	
	public static void search(File dir) {
		File[] list = dir.listFiles();
		for (int i = 0; i < list.length; i++) {
			try {
			System.out.println((list[i].isDirectory()?"Dir":"File")+" : "+list[i].getParent()+"/"+list[i].getName());//Ÿ�Ծ˾ƺ���
			if(list[i].isDirectory()&&list[i].canRead()&&list[i].canExecute()) {//�б� ���� �߰�
				search(list[i]);
			}}
			catch (Exception e) {
				
			}
		}
	}
	
	public static void anotherSearch() {
		LinkedList<File>queue = new LinkedList<File>();
		queue.add(new File("C:\\Program Files"));
		
		while(!queue.isEmpty()) {
			File v =queue.poll();
			System.out.printf("%5s %s\n", (v.isDirectory()?"Dir":"File"), v.getAbsolutePath());
			
			File [] list = v.listFiles();
			try {
				for (File file : list) {
					
					if(file.isDirectory() && file.canExecute() && file.canRead()) {
						queue.add(file);
					}else {
						System.out.printf("%5s %s\n", (v.isDirectory()?"Dir":"File"), v.getAbsolutePath());
					}
				}
			}
			catch (Exception e) {
				
			}
		}
	}

}
