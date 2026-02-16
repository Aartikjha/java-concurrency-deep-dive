package reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadwriteLock {
	
	private int count = 0;
	
	private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	
	private final Lock ReadLock = lock.readLock();
	
	private final Lock Writelock = lock.writeLock();
	
	public void increment() {
		Writelock.lock();
		try {
			count++;
			Thread.sleep(50);  // will give chance to another thread
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Writelock.unlock();
		}
	}
	public int getCount() {
		ReadLock.lock();
		try {
			return count;
		}finally {
			ReadLock.unlock();
		}
		
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ReadwriteLock rw = new ReadwriteLock();
		Runnable readTask = new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName() + " read " + rw.getCount());
				}
			}
			
		};
		Runnable writeTask = new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					rw.increment();
					System.out.println(Thread.currentThread().getName() + " incremented ");
				}
			}
			
		};
		Thread WriterThread = new Thread(writeTask);
		Thread readerThread1 = new Thread(readTask);
		Thread readerThread2 = new Thread(readTask);
		
		WriterThread.start();
		readerThread1.start();
		readerThread2.start();

		WriterThread.join();
		readerThread1.join();
		readerThread2.join();
		
		System.out.println("Final Count : " + rw.getCount());
	}

}
