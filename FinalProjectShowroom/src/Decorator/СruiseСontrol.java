package Decorator;
public class СruiseСontrol extends CarDecorator {
    public СruiseСontrol(Car car) {
        super(car);
    }

    public void addTuning() {
        System.out.println("Added cruise control");
    }

    public void assemble() {
        super.assemble();
        addTuning();
    }
}