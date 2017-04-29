package Q1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NSLookup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InetAddress[] addresses = InetAddress.getAllByName(	args[0] );
			
			for (int i = 0; i < addresses.length; i++) {
	
				System.out.println("Hostname is: "+addresses[i].getHostName());
				System.out.println("IP Address is: "+addresses[i].getHostAddress());
			
				System.out.println("********************************************************************");
			}
		    }
		    catch (UnknownHostException e) {
		     System.out.println("Could not find: "+args[0]);
		    }

	}

}
