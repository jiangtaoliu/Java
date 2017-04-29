package Q4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class MyServer {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		ServerSocket server=null;
				
        //1 create server socket
		 server = new ServerSocket(5000);
		        	
		 while(true)
		 {
			 
			//2 listen to client connection
		    System.err.println ("Serve is listening...");
		    Socket socket = server.accept();
		
	        Thread timeServer = new Thread("TimeServer")
			{
				public void run()
				{
					DataInputStream dis=null;
					DataOutputStream dos=null;
					try
			        {
						dos = new DataOutputStream(socket.getOutputStream());
			        }
			        catch(IOException e)
			        {
			            e.printStackTrace();
			        }
					
					
					System.err.println ("Serve is broardcasting...");
					try {
						//3 send time to client	 
						Date currentDate = new Date();
			        	//dos.writeUTF(Long.toString(System.currentTimeMillis()));  
						dos.writeUTF(currentDate.toString());
			        	Thread.sleep(1000);
			        	
			        	socket.close();
					} catch (IOException | InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 

				}

			};
        
			timeServer.start();
		 }
		 
		//4 close server
		//server.close();    
	}

}
