package Factory;

import Decorator.Car;

public class SedanCarFactory implements CarFactory {
    public Car createCar() {
        return new SedanCar();
    }
}