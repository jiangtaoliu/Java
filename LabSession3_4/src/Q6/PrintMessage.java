package Q6;

public class PrintMessage {

	
	
	
	public void out(String myMsg)
	{
		for(int i=0;i<myMsg.length();i++)
		{
			System.out.print(myMsg.charAt(i));
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("");
	}
}
