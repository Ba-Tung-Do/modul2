import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OrderManager manager = new OrderManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n Order Management");
            System.out.println("1. Add new order (Electronics/Clothing)");
            System.out.println("2. Remove order by ID");
            System.out.println("3. Display all orders");
            System.out.println("4. Display revenue report");
            System.out.println("5. Sort by order date");
            System.out.println("6. Sort by customer name");
            System.out.println("7. Sort by total price");
            System.out.println("8. Show operation history");
            System.out.println("9. Save orders to file");
            System.out.println("10. Load orders from file");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter type (1-Electronics, 2-Clothing): ");
                    int type = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Order ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Customer Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Order Date (yyyyMMdd): ");
                    int date = scanner.nextInt();
                    if (type == 1) {
                        System.out.print("Item Price: ");
                        double price = scanner.nextDouble();
                        System.out.print("Warranty Months: ");
                        int months = scanner.nextInt();
                        manager.addOrder(new ElectronicsOrder(id, name, date, price, months));
                    } else {
                        System.out.print("Base Price: ");
                        double basePrice = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Size: ");
                        String size = scanner.nextLine();
                        manager.addOrder(new ClothingOrder(id, name, date, basePrice, size));
                    }
                    break;
                case 2:
                    System.out.print("Enter Order ID to remove: ");
                    String removeId = scanner.nextLine();
                    manager.removeOrder(removeId);
                    break;
                case 3:
                    manager.displayAllOrders();
                    break;
                case 4:
                    manager.displayRevenueReport();
                    break;
                case 5:
                    manager.sortByOrderDate();
                    System.out.println("Sorted by order date.");
                    break;
                case 6:
                    manager.sortByCustomerName();
                    System.out.println("Sorted by customer name.");
                    break;
                case 7:
                    manager.sortByTotalPrice();
                    System.out.println("Sorted by total price.");
                    break;
                case 8:
                    manager.printHistory();
                    break;
                case 9:
                    System.out.print("Enter filename to save: ");
                    String saveFile = scanner.nextLine();
                    manager.saveToFile(saveFile);
                    break;
                case 10:
                    System.out.print("Enter filename to load: ");
                    String loadFile = scanner.nextLine();
                    manager.loadFromFile(loadFile);
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }
}
