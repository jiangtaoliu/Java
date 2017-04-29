package Question3;

public class Question3 {

	public static void main(String[] args) {
		int x = 5;
		int y = 2;
		
		if (x>y)
		{
			int t=x; y = x;
		    x= t;
		    System.out.println("x = " + x + " and y= "+y);
		} 
		
		else 
		{
			System.out.println("Have a nice day!");
		} 
	}
}
