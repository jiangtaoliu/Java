package Question8;

// Source code can be found at http://www.javaworld.com/javaworld/jw-07-1998/jw-07- exceptions.html
class Example1 {
	public static void main(String[] args) {
		int temperature = 0; 
		if (args.length > 0) 
		{
			try {
				temperature = Integer.parseInt(args[0]);
			}
			catch(NumberFormatException e) {
				System.out.println("Must enter integer as first argument."); 
				return;
			}
		} 
		else 
		{
			System.out.println("Must enter temperature.");
			return;
		}
		// Create a new coffee cup and set the temperature of
		// its coffee.
		CoffeeCup cup = new CoffeeCup(); 
		cup.setTemperature(temperature);
		// Create and serve a virtual customer. 
		VirtualPerson cust = new VirtualPerson(); 
		VirtualCafe.serveCustomer(cust, cup);
	}
}
