package Decorator;
public class MultiSteering extends CarDecorator {
    public MultiSteering(Car car) {
        super(car);
    }
    public void addTuning() {
        System.out.println("Added Multi-steering option");
    }
    public void assemble() {
        super.assemble();
        addTuning();
    }
}