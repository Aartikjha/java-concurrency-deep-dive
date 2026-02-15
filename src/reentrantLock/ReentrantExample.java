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

//================================================================================================================
//Reentrant Lock Concept

//Reentrant means:
//Same thread can acquire the same lock multiple times.
//Internally:
//It maintains: Owner thread & Hold count
////If same thread calls lock() again → hold count increases.

//Unlock Behavior -> Execution flow:

//Step	Action	Hold Count
//outer  lock()	acquired	1
//inner  lock()	re-acquired	2
//inner  unlock()	decremented	1
//outer  unlock()	decremented	0 (fully released)
//
//Lock releases only when hold count becomes 0.
//================================================================================================================
//Lock Acquisition Methods
//1. lock()

//Purpose: Acquires the lock.
//If lock is free → immediately acquired
//If locked → thread blocks (goes to wait queue)
//Not interruptible while waiting
//
//===============================================================================================================
//2. lockInterruptibly()

//Purpose: Acquires the lock but allows interruption.
//If waiting and thread is interrupted → throws InterruptedException
//Useful in responsive systems
//Use when you want: Thread cancellation support while waiting

//===============================================================================================================
//3. tryLock()

//Purpose: Attempts to acquire lock without blocking.
//Returns true → lock acquired
//Returns false → lock unavailable
//Does NOT wait
//Useful for:  Avoiding deadlocks & Non-blocking algorithms

//==============================================================================================================
//4. tryLock(long time, TimeUnit unit)

//Purpose: Waits up to given time to acquire lock.
//Returns true if acquired within timeout
//Returns false if time expires
//Throws InterruptedException if interrupted
//Used when: You want bounded waiting.

//===============================================================================================================
//Lock Release Method
//5. unlock()

//Purpose: Releases the lock.
//Decrements hold count
//Lock fully released only when hold count = 0
//Must be called in finally block
//⚠ If not unlocked → deadlock risk

//=================================================================================================================
