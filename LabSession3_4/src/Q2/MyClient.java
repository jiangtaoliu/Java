package Q2;

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
         
            //2 send message
            String clientMessageString = "Hello";
            dos.writeUTF(clientMessageString); // send to Server
           
            dos.flush();
            
           //3 read message from server
            String rMsg = dis.readUTF(); //read the response from the Server
    		System.out.println("From server: " + rMsg);   // print it on the screen
            

    		//4 close connection
    		Thread.sleep(1000*30);
    		client.close();
    		System.err.println ("Client closed");
    		
        }
        catch(IOException e)
        {
            e.printStackTrace();
        } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
