package Strategy;
public class CreditStrategy implements SalesStrategy {
    public void sellCar() {
        System.out.println("\nCongratulations, you have successfully ordered a car on credit. Wait for your car!");
    }
}