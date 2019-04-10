
import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;


public class MyFileOutput{
	
	public static void main(String[] args) {
		File file,fileName;
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入目录名：");
		String fileNamem=sc.next();
		file=new File(fileNamem);
		System.out.println("请输入文件名：");
		String name=sc.next();
		System.out.println("回车暂停和开始");
		
		Deque deque=new ArrayDeque();
		deque.add(file.getAbsolutePath());
		
		MyThread mt=new MyThread(deque,name);
		mt.start();
	}
}
