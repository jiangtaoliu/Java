package Q3;

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
        	
        	//2 listen to client connection
        	System.err.println ("Serve is listening...");
            Socket socket = server.accept();
            dos = new DataOutputStream(socket.getOutputStream());
            
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
		
		System.err.println ("Serve  broardcasts");
		
		try {
			//3 send time to client	 
			Date currentDate = new Date();
        	//dos.writeUTF(Long.toString(System.currentTimeMillis()));  
			dos.writeUTF(currentDate.toString());
        	Thread.sleep(2000);
        	
        	//4 close server
			server.close();
			System.err.println ("Serve close");
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
