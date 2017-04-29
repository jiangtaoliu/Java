import java.net.*;

public class NSLookup {
    public static void main (String args[]) {
        try {
    	    String name = args[0];
    	    System.out.println("Host name:" + name);
	        InetAddress[] addresses = InetAddress.getAllByName(name);
	        for (int i = 0; i < addresses.length; i++) {
	            System.out.println("IP address: " + addresses[i]);
	        }
        }
        catch (UnknownHostException e) {
            System.out.println("Could not find www.unitec.ac.nz");
        }
    }
}
