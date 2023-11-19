package Factory;

import Decorator.Car;

public class CoupeCar implements Car {
    public void assemble() {
        System.out.println("Assembling a BMW 4 Series Coupe(Coupe)");
    }

    public void addTuning() {}
}