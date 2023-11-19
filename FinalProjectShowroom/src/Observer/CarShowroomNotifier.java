package Observer;
import java.util.ArrayList;
import java.util.List;

public class CarShowroomNotifier {
    private List<CarObserver> observers = new ArrayList<>();
    public void addObserver(CarObserver observer) {
        observers.add(observer);
    }
    public void removeObserver(CarObserver observer) {
        observers.remove(observer);
    }
    public void notifyObservers(String message) {
        for (CarObserver observer : observers) {
            observer.update(message);
        }
    }
}