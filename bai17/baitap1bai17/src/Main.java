import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị tất cả sản phẩm");
            System.out.println("3. Tìm kiếm sản phẩm theo mã");
            System.out.println("4. Thoát");
            System.out.print("Chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập mã sản phẩm: ");
                    String id = scanner.nextLine();
                    System.out.print("Nhập tên: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập giá: ");
                    double price = Double.parseDouble(scanner.nextLine());
                    System.out.print("Nhập hãng sản xuất: ");
                    String manufacturer = scanner.nextLine();
                    System.out.print("Nhập mô tả: ");
                    String description = scanner.nextLine();

                    Product p = new Product(id, name, price, manufacturer, description);
                    manager.addProduct(p);
                    System.out.println("Thêm thành công!");
                    break;

                case 2:
                    System.out.println("Danh sách sản phẩm:");
                    for (Product prod : manager.getAllProducts()) {
                        System.out.println(prod);
                    }
                    break;

                case 3:
                    System.out.print("Nhập mã cần tìm: ");
                    String searchId = scanner.nextLine();
                    Product found = manager.searchById(searchId);
                    if (found != null) {
                        System.out.println("Tìm thấy: " + found);
                    } else {
                        System.out.println("Không tìm thấy sản phẩm.");
                    }
                    break;

                case 4:
                    System.out.println("Thoát chương trình.");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
