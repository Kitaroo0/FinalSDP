package Decorator;
public class PowerSteering extends CarDecorator {
    public PowerSteering(Car car) {
        super(car);
    }
    public void addTuning() {
        System.out.println("Added Power Steering option");
    }
    public void assemble() {
        super.assemble();
        addTuning();
    }
}