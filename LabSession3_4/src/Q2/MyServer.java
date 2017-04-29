package Q2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
        try
        {
        	//1 create server socket
        	ServerSocket server = new ServerSocket(5000);
            
        	
        	//2 listen to client connection
        	System.err.println ("Serve is listening...");
            Socket socket = server.accept();
            
            
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            //3 read message from client	
        	String myMsg = dis.readUTF(); 
        	
        	//4 send message to client	 
        	if( myMsg.compareTo("Hello")==0)
          		dos.writeUTF("Hi there, got your message!");  
        	//5 close server
            Thread.sleep(1000*2);
            server.close();    
            System.err.println ("Serve closed...");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
        
        
        
	}

}
