package Strategy;
public class SalesContext {
    private SalesStrategy salesStrategy;

    public SalesContext(SalesStrategy salesStrategy) {
        this.salesStrategy = salesStrategy;
    }

    public void setSalesStrategy(SalesStrategy salesStrategy) {
        this.salesStrategy = salesStrategy;
    }

    public void executeSalesStrategy() {
        salesStrategy.sellCar();
    }
}