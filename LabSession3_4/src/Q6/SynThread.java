package Q6;

public class SynThread extends Thread {
	
private PrintMessage pMsg;
private String msg;
	
	public SynThread(String out,PrintMessage tgt)
	{
		pMsg = tgt;
		msg = out;
	}
	public void run()
	{
		
		synchronized(pMsg)
		{
			pMsg.out(msg);
		}
		
	}
}
