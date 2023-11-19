package Strategy;
public class CashStrategy implements SalesStrategy {
    public void sellCar() {
        System.out.println("\nCongratulations, you have successfully ordered a car in cash. Wait for your car!");
    }
}