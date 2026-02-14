package reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {
	
	private final ReentrantLock lock = new ReentrantLock();
	
	public void outerMethod() {
		lock.lock();
		try {
		System.out.println("Outer Method");
		innerMethod();
	   } finally {
		lock.unlock();
	}
  }
	public void innerMethod() {
		lock.lock();
		try {
		System.out.println("Inner Method");
		
	   } finally {
		lock.unlock();
	}
  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReentrantExample ex = new ReentrantExample();
		ex.outerMethod();

	}

}
