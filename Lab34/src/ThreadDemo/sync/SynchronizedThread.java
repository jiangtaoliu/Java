package ThreadDemo.sync;
import ThreadDemo.common.NumberSummation;


public class SynchronizedThread extends Thread {
	
	int max;
	
	NumberSummation job; // shared variable
	
	boolean running = true;
	
	public boolean isRunning() {
		return running;
	}

	public SynchronizedThread(String threadName, NumberSummation job, int i)
	{
		super(threadName);
		
		this.job = job;
		this.max = i;
	}
	
	public void run()
	{
		for (int i = 0; i< max; i++)
		{
			synchronized(job) // use synchronized keyword to make sure that only one thread can access this block of code at a time
			{
				int number = job.getNumber();
				
				number = number + 1;
				
				job.setNumber(number);
			}
		}
		running = false;
	}
}
