package methods;

public class SetPriority extends Thread {
	public SetPriority(String name) {
		super(name);
	}
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			String a = "";
			for (int j = 0; j < 10000; j++) {
				a += "a";
			}
			System.out.println(Thread.currentThread().getName() + " Priority :" + Thread.currentThread().getPriority() + " Count:" + i);
			try {
			Thread.sleep(10);
			
			} catch(Exception e) {       
				
		}
	}
	}
	public static void main(String[] args)throws InterruptedException {
		// TODO Auto-generated method stub
		  SetPriority l = new SetPriority("LOW PRIORITY THREAD");
		  SetPriority m = new SetPriority("MEDIUM PRIORITY THREAD");
		  SetPriority n = new SetPriority("HIGH PRIORITY THREAD");
		  
		l.setPriority(MIN_PRIORITY);
		m.setPriority(MAX_PRIORITY);
		n.setPriority(NORM_PRIORITY);
		
		l.start();
		m.start();
		n.start();
	}
}



//setPriority() is used to suggest to the thread scheduler which thread should get more CPU time relative to others.
//In Java, every thread has a priority:
//Thread.MIN_PRIORITY  = 1
//Thread.NORM_PRIORITY = 5  (default)
//Thread.MAX_PRIORITY  = 10
//---------------------------------------------------------------------------------------------------------------------
//Why We Use setPriority()
//1️ To Give Important Tasks More CPU Time
//---------------------------------------------------------------------------------------------------------------------
//Example:
//Background logging thread → low priority
//Real-time data processing → high priority
//
//If some tasks are less important (like cleanup jobs), you can lower their priority so they don’t compete heavily with critical threads.
//setPriority() is only a hint to the OS scheduler.
//
//It does NOT guarantee:
//Execution order
//Immediate execution
//Completion before other threads
//-------------------------------------------------------------------------------------------------------------------------
// What Happens When You Call start()

//=================================================================================================================
//The JVM just:
//Creates the thread
//Manages thread states
//Handles synchronization
//Coordinates with OS
//===================================================================================================================
//OS Level – Real Scheduling Happens Here
//Once JVM creates a thread, the OS scheduler takes control.
//Modern OS (Linux, Windows, macOS) use: Preemptive Scheduling
//Means:
//OS can interrupt a running thread
//Give CPU to another thread

================================================================================================================
//
//How OS Scheduler Works
//Step 1: Ready Queue
//All runnable threads go into a ready queue.
//Step 2: Priority Check
//Scheduler checks:
//Thread priority
//CPU availability
//Time slice remaining
//
//Step 3: Context Switching
//If another thread must run:
//CPU state of current thread is saved
//New thread state is loaded
//CPU starts executing new thread
//This is called:Context Switching
//
//===============================================================================================================
//CPU Level – What Actually Runs
//CPU can only execute:
//👉 One thread per core at a time
//If you have:
//4 cores → 4 threads truly parallel
//100 threads → OS keeps switching between them
//That’s why context switching exists.
//
//==================================================================================================================





