package Q5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;

public class ClientThread extends Thread {

	private Socket socket;
	public DataOutputStream dos;
	
	public void run()
	{
		
			System.err.println ("Serve is broardcasting...");
			try {
				//3 send time to client	 
				Date currentDate = new Date();
	        	dos.writeUTF(currentDate.toString());
	        	Thread.sleep(2000);
   	        	socket.close();
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		
			
	}
	
	public ClientThread(Socket remoteClient)
	{
		try {
			socket = remoteClient;
			dos = new DataOutputStream(remoteClient.getOutputStream());
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
		
}
