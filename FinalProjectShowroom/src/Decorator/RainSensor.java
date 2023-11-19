package Decorator;
public class RainSensor extends CarDecorator {
    public RainSensor(Car car) {
        super(car);
    }
    public void addTuning() {
        System.out.println("Added Rain sensor option");
    }
    public void assemble() {
        super.assemble();
        addTuning();
    }
}