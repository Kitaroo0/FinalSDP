package Factory;
import Decorator.Car;

public class WagonCarFactory implements CarFactory {
    public Car createCar() {
        return new WagonCar();
    }
}