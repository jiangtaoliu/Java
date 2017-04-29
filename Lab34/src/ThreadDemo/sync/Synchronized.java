package ThreadDemo.sync;
import ThreadDemo.common.NumberSummation;


public class Synchronized implements NumberSummation {

	// The non-deterministic nature of the thread scheduling algorithms means that sometimes one of the threads
	// can hold onto a really old value, increment it and then set that number so that the number is less than 300

	int number = 0;
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Synchronized() {
		//System.out.println("Synchronized");
		
		SynchronizedThread t1 = new SynchronizedThread("Thread 1",this,100);
		SynchronizedThread t2 = new SynchronizedThread("Thread 2",this,100);
		SynchronizedThread t3 = new SynchronizedThread("Thread 3",this,100);
		
		t1.start();
		t2.start();
		t3.start();
		
		while(t1.isRunning() || t2.isRunning() || t3.isRunning())
		{
			
		}
		
		System.out.println(getNumber());
		
	}
	
	public static void main(String[] args)
	{
		new Synchronized();
	}
}
