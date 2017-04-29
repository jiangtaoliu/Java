package BackServerTime;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class ClientTime {
    public static void main(String[] args) throws InterruptedException
    {
        try
        {
            Socket client = new Socket("localhost",5000);
            System.out.println ("A new Client created and connected to Server!");
            
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            DataInputStream dis = new DataInputStream(client.getInputStream());
         
            System.out.println ("Client writing stuff to Server...");
                 
            String clientMessageString = "Hello, Could you please send me your time";
            dos.writeUTF(clientMessageString); // send to Server
            System.out.println ("Client just sent this to Server: "+ clientMessageString);
            
            dos.flush();
            
            System.out.println ("Client reading the response from Server...");
            String resp = dis.readUTF(); //read the response from the Server
    		System.out.println("The response from the Server was: " + resp);   // print it on the screen
            

    		Thread.sleep(50*60);
    		
    		client.close();
    		System.out.println ("\nClient closed the connection");
    		
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
