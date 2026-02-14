package methods;

public class Run extends Thread {
	@Override
	public void run() {
		System.out.println("Thread is running");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Run t1 = new Run();
		t1.start();

	}

}


//JVM does the following:
// t1.start();---------------------------------------------------------------------
//Creates a new thread in the OS.
//Allocates a new call stack for that thread.
//Moves thread to RUNNABLE state.
//Thread scheduler assigns CPU.
//The new thread begins execution by calling:
//
//run() is the method that contains the thread's execution logic and acts as the starting point of the new thread’s call stack.

//-------------------------------------------------------------------------------------
//Why We Override run()
//
//Because:
//Thread class already has a default run() method (empty).
//To define custom behavior, we override it.

//------------------------------------------------------------------------------------
//The run() method defines the execution logic of a thread. When the start() method is invoked, the JVM creates a new thread and 
//calls the run() method on that thread, executing its code concurrently.

//The run() method serves as the entry point of the new thread’s execution path and
//is invoked by the JVM after thread initialization.