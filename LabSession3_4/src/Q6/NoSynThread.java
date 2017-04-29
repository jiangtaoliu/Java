package Q6;

public class NoSynThread extends Thread {
	
	private PrintMessage pMsg;
	private String msg;
		
		public NoSynThread(String out,PrintMessage tgt)
		{
			pMsg = tgt;
			msg = out;
		}
		public void run()
		{
			
			
				pMsg.out(msg);
			
			
		}
}
