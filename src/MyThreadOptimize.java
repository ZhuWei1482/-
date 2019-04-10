import java.io.File;
import java.util.Deque;

public class MyThreadOptimize extends Thread {
	private Deque deque;
	private String name;
	public static final int STOP = 1;
	public static final int RUNNING = 2;
	public static final int SUSPEND = 3;
	public static int dd = 0;
	private int state = STOP;

	public void run() {
		while (!deque.isEmpty()) {
			String s = (String) deque.pollFirst();
			File t = new File(s);
//			System.out.println(t.getAbsolutePath());
			File fileName = new File(t.getAbsolutePath(),name);
			String[] t2 = t.list();
			if (t2 != null) {
				for (String f2 : t2) {
					deque.add(t.getPath() + "\\" + f2);
				}
			}

			if (state == SUSPEND) {
				synchronized (this) {
					try {
						dd = 1;
						wait();
					} catch (InterruptedException e) {
					}
				}
			}

			if (fileName.isFile()) {
				if (fileName.exists()) {
					System.out.println(fileName.getAbsolutePath());
					continue;
				}
			}
		}
		 dd=3;
		 System.out.println("���ҽ���");
	}

	public MyThreadOptimize(Deque deque, String name) {
		this.deque = deque;
		this.name = name;
		state = RUNNING;
	}

	public MyThreadOptimize() {
		state = RUNNING;
	}

	// ���̹߳���
	public void normalSuspend() {
		state = SUSPEND;
	}

	// �ָ��߳�����
	public synchronized void normalResume() {
		dd = 0;
		state = RUNNING;
		notify();
	}

}
