package Decorator;
public class NightVision extends CarDecorator {
    public NightVision(Car car) {
        super(car);
    }
    public void addTuning() {
        System.out.println("Added Night vision option");
    }
    public void assemble() {
        super.assemble();
        addTuning();
    }
}