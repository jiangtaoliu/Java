package Q5;

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
		DataInputStream dis=null;
		DataOutputStream dos=null;
		try
        {
        	//1 create server socket
        	server = new ServerSocket(5000);
            
        	while(true)
        	{
        	//2 listen to client connection
        		System.err.println ("Serve is listening...");
        		Socket socket = server.accept();
        		
        		ClientThread client = new ClientThread(socket);
        		System.err.println ("client connected");
        		client.start();
        	}

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
	
	}
			

}
