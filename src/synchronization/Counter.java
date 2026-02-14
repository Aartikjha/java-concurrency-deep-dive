package synchronization;

public class Counter {
	
	private int count = 0;
	
//	public synchronized void increment() {   This is for whole method synchronized.
//		count++;
//	}
	//or if we want particular line to be synchronized then we do this. it means at one time one thread can access only
	public void increment() {
		synchronized(this) {
		  count++;
	}
}
	
	public int getCount() {
		return count;
	}

}
