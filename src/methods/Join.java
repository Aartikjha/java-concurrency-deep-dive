package methods;

public class Join extends Thread {
	@Override
	public void run() {
			try {
			Thread.sleep(2000);
			System.out.println("child running");
			} catch(InterruptedException e) {       // Requires try-catch because interruption is possible 
				throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) throws InterruptedException {   // join() throws InterruptedException
		// TODO Auto-generated method stub
		Join t1 = new Join();
		t1.start();
		t1.join();                               // Helps in maintaining execution order
		System.out.println("t1 finished");
	}
}

//Why join() Is Important in Real Applications
//🔹 1. Ensures correct execution order
//When one task depends on another.
//Used in:
//File processing
//Data aggregation
//Multi-step computation

//join() is used to make one thread wait for another thread to finish.