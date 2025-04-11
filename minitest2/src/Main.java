import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Gán tên kho mặc định ban đầu
        Product.setStoreName("Kho Tổng ABC");

        // Khởi tạo danh sách sản phẩm
        Product[] products = new Product[5];
        products[0] = new Product(1, "Tivi", 15000000, 5);
        products[1] = new Product(2, "Tủ lạnh", 12000000, 3);
        products[2] = new Product(3, "Điện thoại", 9000000, 10);
        products[3] = new Product(4, "Máy giặt", 8000000, 4);
        products[4] = new Product(5, "Máy lạnh", 10000000, 8);

        int choice;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Hiển thị danh sách sản phẩm");
            System.out.println("2. Tìm kiếm sản phẩm theo tên");
            System.out.println("3. Đổi tên kho");
            System.out.println("4. Thống kê");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng thừa

            switch (choice) {
                case 1:
                    System.out.println("=== DANH SÁCH SẢN PHẨM ===");
                    for (Product p : products) {
                        p.display();
                    }
                    break;

                case 2:
                    System.out.print("Nhập tên sản phẩm cần tìm: ");
                    String searchName = scanner.nextLine();
                    boolean found = false;
                    for (Product p : products) {
                        if (p.getName().equalsIgnoreCase(searchName)) {
                            System.out.println("Đã tìm thấy sản phẩm:");
                            p.display();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Không tìm thấy sản phẩm.");
                    }
                    break;

                case 3:
                    System.out.print("Nhập tên kho mới: ");
                    String newStore = scanner.nextLine();
                    Product.setStoreName(newStore);
                    System.out.println("Tên kho đã được cập nhật thành: " + Product.getStoreName());
                    break;

                case 4:
                    // In sản phẩm có giá trị tồn kho > 1.000.000
                    System.out.println("=== SẢN PHẨM CÓ GIÁ TRỊ TỒN KHO > 1.000.000 ===");
                    for (Product p : products) {
                        if (p.getInventoryValue() > 1_000_000) {
                            p.display();
                        }
                    }

                    // Tìm sản phẩm tồn kho lớn nhất
                    Product maxProduct = products[0];
                    for (int i = 1; i < products.length; i++) {
                        if (products[i].getQuantity() > maxProduct.getQuantity()) {
                            maxProduct = products[i];
                        }
                    }
                    System.out.println("=== SẢN PHẨM CÓ TỒN KHO LỚN NHẤT ===");
                    maxProduct.display();

                    // Thống kê
                    System.out.println("=== THỐNG KÊ ===");
                    System.out.println("Tổng số sản phẩm được tạo: " + Product.getTotalProduct());
                    System.out.println("Tổng giá trị tồn kho: " + Product.getTotalInventoryValue());
                    System.out.println("Giá trung bình: " + Product.getAveragePrice());
                    break;

                case 0:
                    System.out.println("Đã thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }

        } while (choice != 0);

        scanner.close();
    }
}
