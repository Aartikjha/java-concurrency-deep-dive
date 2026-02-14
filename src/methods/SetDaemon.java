package methods;

public class SetDaemon extends Thread{
	
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Hello !");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetDaemon t1 = new SetDaemon();
		t1.setDaemon(true);
		SetDaemon t2 = new SetDaemon();
		t2.setDaemon(true);
		t2.start();
		t1.start();
		t1.interrupt();;
		t2.interrupt();
		System.out.println("Hey , I'm done");
		
	}

}
//A daemon thread is:
//
//A background thread that runs to support user threads and automatically stops when all user threads finish.
//🔥 Types of Threads in Java
//1️⃣ User Thread (Non-Daemon)
//Default type
//JVM waits for them to finish
//Example: main thread
//
//2️⃣ Daemon Thread
//Background service thread
//JVM does NOT wait for it
//Automatically stops when all user threads end
