package Decorator;
public abstract class CarDecorator implements Car {
    protected Car decoratedCar;
    public CarDecorator(Car car) {
        this.decoratedCar = car;
    }

    public void assemble() {
        decoratedCar.assemble();
    }
}