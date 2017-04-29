package BackServerTime;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// ************* Run the Server code first ***********************

public class ServerTime {
	public static void main(String[] args)
	{
        ServerSocket server = null;
        try
        {
            server = new ServerSocket(5000);
            System.out.println ("Server Socket created!");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
        while(true)
        {
            try
            {
            	System.out.println ("Server waiting for clients on port " + server.getLocalPort()+"...");
                Socket socket = server.accept();
                System.out.println ("\nServer just accepted a client: " + socket.toString());
                
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                
                while(true)
                {
                	try
                	{
                		 System.out.println ("\nServer waiting to read stuff from client...");
                		
                		 String myMesg = dis.readUTF(); //read mesg from client
                		 System.out.println ("The string sent by Client was: " + myMesg);
                		 
                		 long localtime = System.currentTimeMillis();
                		 System.out.println ("Server echoing the string message back to client...");               
                		 dos.writeUTF("The Server's Local Time is "+localtime);  // modify the client's message and send it back to client 
                	
                	}
                	catch(EOFException e)
                	{
                		break;
                	}
                }
                             
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        
	}
}