package multithreading.basic;

public class ThreadRunnable implements Runnable{
	@Override
	public void run() {
		for (int i = 0 ;i<10;i++) {
			System.out.println("Thread Runnable "+Thread.currentThread().getName());
		}
		
	}
}
