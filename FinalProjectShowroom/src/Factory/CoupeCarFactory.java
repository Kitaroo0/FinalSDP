package Factory;

import Decorator.Car;

public class CoupeCarFactory implements CarFactory {
    public Car createCar() {
        return new CoupeCar();
    }
}