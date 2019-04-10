import java.io.*;
import java.util.Deque;

public class MyThread extends Thread {
	private Deque deque;
	private String name;

	@Override
	public void run() {
		FileInputStream fin = new FileInputStream(FileDescriptor.in);
		MyThreadOptimize mto=new MyThreadOptimize(deque,name);
		System.out.println("������.........");
		mto.start();
		while (true) {
			try {
				if (fin.read() == '\r') {
					if (mto.dd==0) {
						mto.normalSuspend();
						System.out.println("��ͣ");
					} else {
						mto.normalResume();
						System.out.println("��ʼ");
					}
				}
			} catch (Exception e) {
				System.out.println("����");
			}
		}
	}

	public MyThread(Deque deque, String name) {
		this.deque = deque;
		this.name = name;
	}
}
