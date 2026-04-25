package multithreading.basic;

public class MyThread extends Thread {

	@Override
	public void run() {
		System.out.println("RUNNING");

		try {
			Thread.sleep(6500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws InterruptedException {
		// Thread state
		// 1. New
		MyThread mt = new MyThread();

		System.out.println(mt.getState());

		// 2. RUNNABLE
		mt.start();
		System.out.println(mt.getState());
		
		// 3. TIME_WAITED 
		// The main thread will execute first in 1 secs then the mt will show Time waited
		Thread.sleep(5000);
		System.out.println(mt.getState());
		
		//4. Terminated
		mt.join();
		System.out.println(mt.getState());
		//System.out.println("Main " + Thread.currentThread().getState());
		
	}

}
