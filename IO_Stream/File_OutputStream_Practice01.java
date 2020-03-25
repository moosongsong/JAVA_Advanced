package 입출력연습;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class File_OutputStream_Practice01 {

	public static void main(String[] args) {
		File file = null;
//		파일 만들기
//		file = new File("C:\\bigdataprograming\\data.txt");
//		if(file.exists()) {
//			System.out.println("file exists");
//		}
//		else {
//			System.out.println("file not exists");
//			try {
//				file.createNewFile();
//			} catch (IOException e) {
//				System.out.println("권한이 없습니다.");
//				e.printStackTrace();
//				System.out.println(file.getName()+" is made.");
//			}
//		}
		
		//임시파일 만들기
//		try {
//			file = File.createTempFile("temp_", ".tmp", new File("C:\\bigdataprograming"));
//			System.out.println(file.getAbsolutePath()+"를 생성하였습니다.");
//		} catch (IOException e1) {		}
//		
//		//메인 종료시 파일 삭제
//		file.deleteOnExit();
//		
//		//dir 만들기
//		File dir = null;
//		dir = new File("C:\\bigdataprograming\\backup\\12month");
//		if(dir.exists()) {
//			;
//		}
//		else {
//			dir.mkdirs();
//		}
		
		//10초 시간 걸어놓은거.
//		try {
//			Thread.sleep(10000);
//			
//		}catch (InterruptedException e) {
//		}
		
		
		/////////////////////////////////////////////////////////////////////////
		/*
		 * backup 디렉토리가 없으면 생성하고
		 * backup 하위에 result.log 파일을 생성
		 * result.log 파일의 생성은 존재하지 않을 경우만 생성
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
//				System.out.println("파일 생성.");
//			}
//		}
		
//		//Program Files 에 있는 디렉토리 확인하기
//		File dir = null;
		
//		search(new File("C:\\Program Files"));
		anotherSearch();
		
	}
	
	public static void search(File dir) {
		File[] list = dir.listFiles();
		for (int i = 0; i < list.length; i++) {
			try {
			System.out.println((list[i].isDirectory()?"Dir":"File")+" : "+list[i].getParent()+"/"+list[i].getName());//타입알아보기
			if(list[i].isDirectory()&&list[i].canRead()&&list[i].canExecute()) {//읽기 실행 추가
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
