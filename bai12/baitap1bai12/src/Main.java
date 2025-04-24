import java.io.PrintStream;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager(); //
        Scanner scanner = new Scanner(System.in); // nhap noi dung tu ban phim

        int choice;

        do {
        System.out.println("PRODUCT MANAGER");
        System.out.println("1. Add product");
            System.out.println("2. Edit product by id");
            System.out.println("3. Delete product by id");
            System.out.println("4. Display all products");
            System.out.println("5. Search product by name");
            System.out.println("6. Sort products ascending by price");
            System.out.println("7. Sort products descending by price");
            System.out.println("0. Exit");
            System.out.println(" Choice");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter product ID: ");
                    int id = scanner.nextInt();
                    System.out.println("Enter product name: ");
                    String name = scanner.next();
                    System.out.println("Enter product price: ");
                    double price = scanner.nextDouble();
                    manager.addProduct(new Product(id,name,price));
                    break;
                case 2:
                    System.out.println("Enter product ID to edit: ");
                    int editId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter the new product name: ");
                    String newName = scanner.nextLine();
                    System.out.println("Enter the new product price: ");
                    double newPrice = scanner.nextDouble();
                    manager.editProduct(editId,newName,newPrice);
                    break;
                case 3:
                    System.out.println("Enter product ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    manager.deleteProduct(deleteId);
                    break;
                case 4:
                    manager.displayAllProducts();
                    break;
                case 5:
                    System.out.println("Enter product ID to search: ");
                    String keyword = scanner.nextLine();
                    scanner.nextLine();
                    LinkedList<Product> result = manager.searchProduct(keyword);
                    if (result.isEmpty()) {
                        System.out.println("No products found");
                    } else {
                        for (Product p : result) {
                            System.out.println(result);
                        }
                    }
                    break;
                case 6:
                    manager.sortByPriceAscending();
                    manager.displayAllProducts();
                    break;
                case 7:
                    manager.sortByPriceDescending();
                    manager.displayAllProducts();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice !=0);
    }
}