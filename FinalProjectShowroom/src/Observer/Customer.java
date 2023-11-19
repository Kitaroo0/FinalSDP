package Observer;
public class Customer implements CarObserver {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(name + ": Notification - " + message);
    }
}