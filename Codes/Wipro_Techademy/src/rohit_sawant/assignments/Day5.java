package rohit_sawant.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* WRITE YOUR LOGIC HERE */

enum ItemType {
    BEVERAGE,
    PASTRY
}

interface Orderable {
    double getPrice();
}

abstract class MenuItem implements Orderable {
    protected String name;
    protected double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}

class Beverage extends MenuItem {
    public Beverage(String name, double price) {
        super(name, price);
    }
}

class Pastry extends MenuItem {
    public Pastry(String name, double price) {
        super(name, price);
    }
}

class Order {
    private List<Orderable> items = new ArrayList<>();

    public void addItem(Orderable item) {
        if (item == null) {
            return;
        }

        if (item instanceof MenuItem) {
            items.add(item);
            System.out.println("Order Added: " + ((MenuItem) item).getName());
        }
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Orderable item : items) {
            total += item.getPrice();
        }
        System.out.println("Total Order Cost: " + total);
        return total;
    }
}

/* Non editable starts here */
public class Day5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();

        while (true) {
            int action = scanner.nextInt();
            scanner.nextLine();

            if (action == 4) {
                break;
            }

            if (action < 1 || action > 4) {
                System.out.println("Invalid action. Please choose again.");
                continue;
            }

            switch (action) {
                case 1:
                    String beverageName = scanner.nextLine();
                    double beveragePrice = scanner.nextDouble();
                    scanner.nextLine();
                    Beverage beverage = new Beverage(beverageName, beveragePrice);
                    order.addItem(beverage);
                    break;

                case 2:
                    String pastryName = scanner.nextLine();
                    double pastryPrice = scanner.nextDouble();
                    scanner.nextLine();
                    Pastry pastry = new Pastry(pastryName, pastryPrice);
                    order.addItem(pastry);
                    break;

                case 3:
                    order.calculateTotal();
                    break;

                default:
                    System.out.println("Invalid action. Please choose again.");
            }
        }

        scanner.close();
    }
}
/* Non editable ends here */
