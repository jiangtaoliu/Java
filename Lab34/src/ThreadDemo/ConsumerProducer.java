package ThreadDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class ConsumerProducer {
	public static void main(String[] args)
	{
		final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		final LinkedList <String> words = new LinkedList<String>();
		
		Thread consumer = new Thread("Consumer") // This example only includes one consumer but there could be more
		{
			public void run()
			{
				while(true) // yes run forever
				{
					synchronized(words)
					{
						if(words.isEmpty())
						{
							try
							{
								words.wait(); // signal that the list is empty and that this thread needs to block
							} catch (InterruptedException e)
							{
								e.printStackTrace();
							}
							System.err.println("isAwake");
						}
						else
						{
							System.out.println(words.removeFirst());
						}
					}
				}
				
				
			}
		};
		
		Thread producer = new Thread("Producer")
		{
			public void run()
			{
				while(true)
				{
					try {
						String inputData = reader.readLine();
						
						synchronized(words)
						{
							words.add(inputData);
							words.notify(); // signal that we have added some data to our list
						}
						
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
			}
		};
		
		consumer.start();
		producer.start();
	}
}
