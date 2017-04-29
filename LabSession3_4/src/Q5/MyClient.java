package Q5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MyClient {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
        {
			//1 create connecting
            Socket client = new Socket("localhost",5000);
                        
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            DataInputStream dis = new DataInputStream(client.getInputStream());
           
           //2 read message from server
            String rMsg = dis.readUTF(); //read the response from the Server
    		System.out.println("Time from server: " + rMsg);   // print it on the screen
    		
    		//3 close connection
    		client.close();
    		System.err.println ("Client closed");
    		
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
	}
}
