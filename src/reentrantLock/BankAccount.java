package reentrantLock;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
	
	private int balance = 100;
	
	private final ReentrantLock lock = new ReentrantLock();
	
	public void withdraw(int amount) {
		System.out.println(Thread.currentThread().getName() + " Attempting to withdraw " + amount);
		
		try {
			if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
				 if (balance >= amount) {
					 try {
					 System.out.println(Thread.currentThread().getName() + "Proceeding with withdrawal");
					 Thread.sleep(1000);
					} catch (Exception e) {
						
					} finally {
						lock.unlock();
					}
					 balance -= amount;
					 System.out.println(Thread.currentThread().getName() + "Completed withdrawal Remaining balance : " + balance);
				 }
				 else {
					 System.out.println(Thread.currentThread().getName() + "Insufficient balance");
				 }
			} else {
				 System.out.println(Thread.currentThread().getName() + "Could not acquire the lock, Try again later! ");
			}
		} catch (InterruptedException e) {
			
		}
	}

}
