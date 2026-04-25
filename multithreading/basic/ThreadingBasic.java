package multithreading.basic;

public class ThreadingBasic  extends Thread{
	
	@Override

	public void run() {
		for (int i = 0 ;i<10 ;i++) {
			System.out.println("World "+Thread.currentThread().getName());
		}
	}
}
