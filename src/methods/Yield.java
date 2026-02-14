package methods;

public class Yield extends Thread{
	
	public Yield(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
		System.out.println(Thread.currentThread().getName() + " running");
		Thread.yield();
	}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Yield t1 = new Yield("t1");
     Yield t2 = new Yield("t2");
     
     t1.start();
     t2.start();
	}

}

//yield() is used to:
//Suggest to the thread scheduler that the current thread is willing to pause and allow other threads of the same priority to run.
//It is only a hint, not a guarantee.
//
//Sometimes used in:
//Concurrency demos & Testing race condition