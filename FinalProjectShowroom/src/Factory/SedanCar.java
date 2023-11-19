package Factory;

import Decorator.Car;

public class SedanCar implements Car {
    public void assemble() {
        System.out.println("Assembling a BMW М8 Gran Coupe(Sedan)");
    }

    public void addTuning() {}
}