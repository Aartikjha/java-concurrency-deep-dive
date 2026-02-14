package methods;

public class Interrupt extends Thread {

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println("Thread is running");
		} catch (InterruptedException e) {
			System.out.println("Thread is interrupted" + e); 
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interrupt t1 = new Interrupt();
		t1.start();
		t1.interrupt();

	}
}

//==============================================================================================================
//Why interrupt() Is Used in Java
//interrupt() is used to politely request a thread to stop or wake up.
//It does NOT forcefully kill a thread.
//It just sends a signal.
//
//============================================================================================================
//Real Backend Example Imagine:
//A thread is waiting for DB response
//Server is shutting down
//We call: thread.interrupt();
//Thread: Stops waiting , Cleans up resources ,Exits gracefully
