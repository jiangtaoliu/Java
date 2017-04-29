package Question8;

// In Source Packet in file except/ex1/VirtualCafe.java
class VirtualCafe {
    public static void serveCustomer(VirtualPerson cust,
        CoffeeCup cup) {
        try {
            cust.drinkCoffee(cup);
            System.out.println("Coffee is just right.");
        }
        catch (TooColdException e) {
            System.out.println("Coffee is too cold.");
            // Deal with an irate customer...
        }
        catch (TooHotException e) {
            System.out.println("Coffee is too hot.");
            // Deal with an irate customer...
        }
    }
}