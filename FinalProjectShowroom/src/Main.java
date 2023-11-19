import Adapter.AdapterCurrency;
import Adapter.Currency;
import Adapter.CurrencyAdapter;
import Adapter.Dollar;
import Adapter.Euro;
import Decorator.*;
import Factory.CarFactory;
import Factory.CoupeCarFactory;
import Factory.SedanCarFactory;
import Factory.WagonCarFactory;
import Observer.CarShowroomNotifier;
import Observer.Customer;
import Singleton.CarShowroom;
import Strategy.CashStrategy;
import Strategy.CreditStrategy;
import Strategy.SalesContext;
import Strategy.SalesStrategy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarShowroom showroom = CarShowroom.getInstance();
        CarShowroomNotifier notifier = new CarShowroomNotifier();

        notifier.addObserver(new Customer("Justin"));
        notifier.addObserver(new Customer("Max"));

        int choice;
        while (true){
            System.out.println("\nWelcome to our car dealership!\nSelect an action:\n1. Order a car\n2. Change the price of the car\n3. Add Observer");
            choice = scanner.nextInt();
            if(choice == 1){
                CarFactory wagonCars = new WagonCarFactory();
                CarFactory sedanCars = new SedanCarFactory();
                CarFactory coupeCars = new CoupeCarFactory();
                Car clientCar = null;
                while (true){
                    System.out.println("Choose the model and body of the car you want:\n1. BMW М8 Gran Coupe(Sedan)\n2. BMW M3 Touring(Wagon)\n3. BMW 4 Series Coupe(Coupe)");
                    choice = scanner.nextInt();
                    if(choice == 1){
                        clientCar = sedanCars.createCar();
                        clientCar.assemble();
                        break;
                    } else if (choice == 2) {
                        clientCar = wagonCars.createCar();
                        clientCar.assemble();
                        break;
                    } else if (choice == 3) {
                        clientCar = coupeCars.createCar();
                        clientCar.assemble();
                        break;
                    }
                    else {
                        System.out.println("\nWrong input! Try again.");
                    }
                }
                while (true){
                    System.out.println("\nDo you want to add additional options?\n1. Yes\n2. No");
                    choice = scanner.nextInt();
                    if(choice == 1){
                        while (true){
                            System.out.println("Select an additional option\n1. Сruise control\n2. Climate control\n3. Multi-steering");
                            choice = scanner.nextInt();
                            if (choice == 1){
                                clientCar = new СruiseСontrol(clientCar);
                                clientCar.addTuning();
                                break;
                            } else if (choice == 2) {
                                clientCar = new ClimateControl(clientCar);
                                clientCar.addTuning();
                                break;
                            } else if (choice == 3) {
                                clientCar = new MultiSteering(clientCar);
                                clientCar.addTuning();
                                break;
                            }
                            else{
                                System.out.println("\nWrong input! Try again.");
                            }
                        }
                        while (true){
                            System.out.println("Select the second bonus option\n1. Night Vision\n2. Rain Sensor\n3. Power Steering");
                            choice = scanner.nextInt();
                            if (choice == 1){
                                clientCar = new NightVision(clientCar);
                                clientCar.addTuning();
                                break;
                            } else if (choice == 2) {
                                clientCar = new RainSensor(clientCar);
                                clientCar.addTuning();
                                break;
                            } else if (choice == 3) {
                                clientCar = new PowerSteering(clientCar);
                                clientCar.addTuning();
                                break;
                            }
                            else{
                                System.out.println("\nWrong input! Try again.");
                            }
                        }
                        break;
                    }
                    else if(choice == 2){
                        break;
                    }else {
                        System.out.println("\nWrong input! Try again.");
                    }
                }

                SalesStrategy strategy = null;
                AdapterCurrency curren = null;
                while (true){
                    System.out.println("\nChoose a payment method:\n1. Cash\n2. On credit");
                    int chose = scanner.nextInt();
                    if(chose == 1){
                        while (true){
                            System.out.println("\nWhat is your currency?\n1. Dollar\n2. Euro");
                            chose = scanner.nextInt();
                            if(chose == 1){
                                Currency dollar = new Dollar();
                                curren = new CurrencyAdapter(dollar);
                                break;
                            }
                            else if(chose==2){
                                Currency euro = new Euro();
                                curren = new CurrencyAdapter(euro);
                                break;
                            }
                            else{
                                System.out.println("\nWrong input! Try again.");
                            }
                        }
                        strategy = new CashStrategy();
                        System.out.println("Your currency is: " + curren.getAdapterCurrency());
                        break;
                    }
                    else if(chose==2){
                        strategy = new CreditStrategy();
                        break;
                    }
                    else{
                        System.out.println("\nWrong input! Try again.");
                    }
                }
                SalesContext salesContext = new SalesContext(strategy);
                salesContext.executeSalesStrategy();
                System.out.println("Information about your car:");
                clientCar.assemble();
                break;

            } else if (choice == 2) {
                String carModel = null;
                while (true){
                    System.out.println("Choose a car model:\n1. BMW М8 Gran Coupe(Sedan)\n2. BMW M3 Touring(Wagon)\n3. BMW 4 Series Coupe(Coupe)");
                    int model = scanner.nextInt();
                    if(model == 1){
                        carModel = "BMW М8 Gran Coupe(Sedan)";
                        break;
                    }
                    else if(model == 2){
                        carModel = "BMW M3 Touring(Wagon)";
                        break;
                    }
                    else if(model == 3){
                        carModel = "BMW 4 Series Coupe(Coupe)";
                        break;
                    }
                    else{
                        System.out.println("\nWrong input! Try again.");
                    }
                }
                System.out.println("Enter a new price for the car:");
                int newPrice = scanner.nextInt();
                showroom.setCarPrice(notifier, newPrice, carModel);
            }
            else if(choice == 3){
                System.out.println("Write client name:");
                String name = scanner.next();
                notifier.addObserver(new Customer(name));
                System.out.println("Now client will receive notifications!");
            } else{
                System.out.println("\nWrong input! Try again.");
            }
        }
    }
}