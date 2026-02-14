package multithreading;

public class ThreadLifeCycle extends Thread{
	@Override
	public void run() {
		System.out.println("RUNNING");
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			System.out.println(e);
		}
		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		ThreadLifeCycle t1 = new ThreadLifeCycle();
		System.out.println(t1.getState());
		t1.start();
		System.out.println(t1.getState());
		Thread.sleep(100);
		System.out.println(t1.getState());
		t1.join();
		System.out.println(t1.getState());
	}

}
