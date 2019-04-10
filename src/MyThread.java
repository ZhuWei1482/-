import java.io.*;
import java.util.Deque;

public class MyThread extends Thread {
	private Deque deque;
	private String name;

	@Override
	public void run() {
		FileInputStream fin = new FileInputStream(FileDescriptor.in);
		MyThreadOptimize mto=new MyThreadOptimize(deque,name);
		System.out.println("查找中.........");
		mto.start();
		while (true) {
			try {
				if (fin.read() == '\r') {
					if (mto.dd==0) {
						mto.normalSuspend();
						System.out.println("暂停");
					} else {
						mto.normalResume();
						System.out.println("开始");
					}
				}
			} catch (Exception e) {
				System.out.println("错误");
			}
		}
	}

	public MyThread(Deque deque, String name) {
		this.deque = deque;
		this.name = name;
	}
}
