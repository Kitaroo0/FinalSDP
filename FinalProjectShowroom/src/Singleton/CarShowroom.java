package Singleton;
import Observer.CarShowroomNotifier;
public class CarShowroom {
    private static CarShowroom instance;
    private int price;

    private CarShowroom() {
    }

    public static CarShowroom getInstance() {
        if (instance == null) {
            instance = new CarShowroom();
        }
        return instance;
    }
    public void setCarPrice(CarShowroomNotifier notifier, int carPrice, String carModel){
        this.price= carPrice;
        notifier.notifyObservers("The price of " + carModel + " has changed. New price:" + this.price);
    }
}