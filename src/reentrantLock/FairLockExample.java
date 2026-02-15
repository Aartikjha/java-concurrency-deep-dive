package reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairLockExample {
private final Lock fairLock = new ReentrantLock(true);
	
	public void accessResource() {
		fairLock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + " Acquired the lock");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		} finally {
			System.out.println(Thread.currentThread().getName() + " Released the lock");
			fairLock.unlock();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    UnfairLockExample ex = new UnfairLockExample();
    Runnable  task = new Runnable() {

		@Override
		public void run() {
			ex.accessResource();
		}
    };
    Thread t1 = new Thread(task,"Thread 1");
    Thread t2 = new Thread(task,"Thread 2");
    Thread t3 = new Thread(task,"Thread 3");
    
    t1.start();
    t2.start();
    t3.start();
	}



	

}
