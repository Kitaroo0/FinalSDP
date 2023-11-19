package Factory;

import Decorator.Car;

public class WagonCar implements Car {
    public void assemble() {
        System.out.println("Assembling a BMW M3 Touring(Wagon)");
    }

    public void addTuning() {}
}