
import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;


public class MyFileOutput{
	
	public static void main(String[] args) {
		File file,fileName;
		Scanner sc=new Scanner(System.in);
		System.out.println("������Ŀ¼����");
		String fileNamem=sc.next();
		file=new File(fileNamem);
		System.out.println("�������ļ�����");
		String name=sc.next();
		System.out.println("�س���ͣ�Ϳ�ʼ");
		
		Deque deque=new ArrayDeque();
		deque.add(file.getAbsolutePath());
		
		MyThread mt=new MyThread(deque,name);
		mt.start();
	}
}
