package multithreading.basic;

import java.util.Iterator;

public class MainClass {

	public static void main(String[] args) {
		
		ThreadingBasic t1 = new ThreadingBasic();
		t1.start();
		
		for (int i = 0 ;i<10 ;i++) {
			System.out.println(Thread.currentThread().getName());
		}
		
		ThreadRunnable tr = new ThreadRunnable();
		Thread t2 = new Thread(tr);
		t2.start();
		
	}

}
