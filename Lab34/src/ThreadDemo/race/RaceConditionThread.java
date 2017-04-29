package ThreadDemo.race;
import ThreadDemo.common.NumberSummation;


public class RaceConditionThread extends Thread {
	
	int max;
	
	NumberSummation job; // shared variable
	
	boolean running = true;
	
	public boolean isRunning() {
		return running;
	}

	public RaceConditionThread(String threadName, NumberSummation job, int i)
	{
		super(threadName);
		
		this.job = job;
		this.max = i;
	}
	
	public void run()
	{
		for (int i = 0; i< max; i++)
		{
			int number = job.getNumber();
			
			number = number + 1;
			
			job.setNumber(number);			
			
		}
		running = false;
	}
}
