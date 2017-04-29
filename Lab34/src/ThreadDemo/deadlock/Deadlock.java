package ThreadDemo.deadlock;


public class Deadlock {	

	public static void main(String[] args)
	{
		final Object lock1 = new Object();
		final Object lock2 = new Object();
		
		Thread t1 = new Thread("T1")
		{
			public void run()
			{
				synchronized(lock1)
				{
					System.out.println("Thread 1: Holding lock 1 ...");
					
					// waste some time in reality we'd be processing some stuff
					
					try {
						Thread.sleep(20);
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
					System.out.println("Thread 1: Waiting for lock 2");
					synchronized (lock2)
					{
						System.out.println("Thread 1: Holding both lock 1 and 2");
					}
				}
			}
		};
		
		Thread t2 = new Thread("T2")
		{
			public void run()
			{
				synchronized(lock2)
				{
					System.out.println("Thread 2: Holding lock 2 ...");
					
					// waste some time in reality we'd be processing some stuff
					
					try {
						Thread.sleep(15);
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
					System.out.println("Thread 2: Waiting for lock 1");
					synchronized (lock1)
					{						
						System.out.println("Thread 2: Holding lock 1 and 2");
					}
				}
			}
		};
		
		t1.start();
		t2.start();

		while(t1.isAlive() || t2.isAlive())
		{
			
		}
		// never gonna happen!
		System.out.println("Finished");
	}
}
