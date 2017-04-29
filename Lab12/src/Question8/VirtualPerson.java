package Question8;
// In Source Packet in file except/ex1/VirtualPerson.java
class VirtualPerson {
    private static final int tooCold = 65;
    private static final int tooHot = 85;
    public void drinkCoffee(CoffeeCup cup) throws
        TooColdException, TooHotException {
        int temperature = cup.getTemperature();
        if (temperature <= tooCold) {
            throw new TooColdException();
        }
        else if (temperature >= tooHot) {
            throw new TooHotException();
        }
        //...
    }
    //...
}