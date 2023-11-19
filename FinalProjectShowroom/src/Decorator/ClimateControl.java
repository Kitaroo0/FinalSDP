package Decorator;
public class ClimateControl extends CarDecorator {
    public ClimateControl(Car car) {
        super(car);
    }
    public void addTuning() {
        System.out.println("Added climate control");
    }
    public void assemble() {
        super.assemble();
        addTuning();
    }
}