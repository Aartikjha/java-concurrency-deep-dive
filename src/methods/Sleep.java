package methods;

public class Sleep extends Thread{
	
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
			Thread.sleep(1000);
			} catch(InterruptedException e) {       // Requires try-catch because interruption is possible 
				throw new RuntimeException(e);
			}
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sleep t1 = new Sleep();
		t1.start();

	}
}
//sleep() is a static method of the Thread class that pauses the currently executing thread for a specified amount of time.
//Thread.sleep(1000);
//It pauses the thread for 1000 milliseconds (1 second).

//When sleep(1000) executes:

//The current thread moves from RUNNING → TIMED_WAITING state.
//It stops execution for 1 second.
//After 1 second, it moves back to RUNNABLE.
//Scheduler may allow it to run again.
//sleep() does NOT release locks if the thread is inside a synchronized block.
//
//Uses : Used when you want a delay between operations. 

