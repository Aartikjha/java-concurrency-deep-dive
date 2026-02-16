package deadlock;

 class Pen {
	 public synchronized void writeWithPenAndPaper(Paper paper) {
		 System.out.println(Thread.currentThread().getName() + " is using pen " + this + " and trying to lock paper");
		 paper.finishWriting();
	 }

	 public synchronized void finishWriting() {
		 System.out.println(Thread.currentThread().getName() + " finished using pen " + this);
	 }
 }
 
 class Paper {
	 public synchronized void writeWithPaperAndPen(Pen pen) {
		 System.out.println(Thread.currentThread().getName() + " is using paper " + this + " and trying to lock pen");
		 pen.finishWriting();
	 }

	 public synchronized void finishWriting() {
		 System.out.println(Thread.currentThread().getName() + " finished using paper " + this);
	 }
 }
   class Task1 implements Runnable {
	   
		private Pen pen;
		
		private Paper paper;
		
		public Task1(Pen pen, Paper paper) {
			this.pen = pen;
			this.paper = paper;
		}
		@Override
		public void run() {
			pen.writeWithPenAndPaper(paper);  // Thread locks pen and try to lock paper
			
		}
	   
   }
class Task2 implements Runnable {
	
	private Pen pen;
	
	private Paper paper;
	
	public Task2(Pen pen, Paper paper) {
		this.pen = pen;
		this.paper = paper;
	}

	@Override
	public void run() {
		synchronized(pen) {        // Both threads now acquire locks in the same order (Pen then Paper),
			                      //so circular wait is eliminated and deadlock cannot occur.
			synchronized(paper) {
			paper.writeWithPaperAndPen(pen);  
		}
		}
	} 
   }

public class DeadlockExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pen pen = new Pen();
		Paper paper = new Paper();
		
		Thread thread1 = new Thread(new Task1 (pen, paper), "Thread1");
		Thread thread2 = new Thread(new Task2 (pen, paper), "Thread2");
		
		thread1.start();
		thread2.start();
	}

}

// Deadlock is prevented by enforcing consistent lock ordering.
//Both threads now acquire Pen before Paper, eliminating circular wait and therefore eliminating deadlock.
