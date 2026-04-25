package multithreading.advance;

public class AdvanceMeth extends Thread{	
	
	String name;
	public AdvanceMeth(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			try {
				Thread.sleep(5000);
				Thread.yield();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(Thread.currentThread().getName());
		}
	}
	public static void main(String[] args) {
		//Interrupt
		AdvanceMeth it = new AdvanceMeth("Test Thread");
		it.start();
		it.interrupt();
		//Priority
		AdvanceMeth ft = new AdvanceMeth("first");
		ft.setPriority(MAX_PRIORITY);
		AdvanceMeth st = new AdvanceMeth("second");
		st.setPriority(NORM_PRIORITY);
		AdvanceMeth tt = new AdvanceMeth("third");
		tt.setPriority(MIN_PRIORITY);
		
		ft.start();
		st.start();
		tt.start();
		
		
	}

}
