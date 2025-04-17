import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MaterialManager manager = new MaterialManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Thêm bột");
            System.out.println("2. Thêm thịt");
            System.out.println("3. Sửa theo ID");
            System.out.println("4. Xóa theo ID");
            System.out.println("5. Hiển thị danh sách");
            System.out.println("6. Tính chênh lệch");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("ID: "); String id1 = scanner.nextLine();
                    System.out.print("Tên: "); String name1 = scanner.nextLine();
                    System.out.print("Cost: "); int cost1 = Integer.parseInt(scanner.nextLine());
                    System.out.print("Số tháng trước: "); int months = Integer.parseInt(scanner.nextLine());
                    System.out.print("Quantity: "); int quantity = Integer.parseInt(scanner.nextLine());
                    manager.add(new CrispyFlour(id1, name1, LocalDate.now().minusMonths(months), cost1, quantity));
                    break;

                case 2:
                    System.out.print("ID: "); String id2 = scanner.nextLine();
                    System.out.print("Tên: "); String name2 = scanner.nextLine();
                    System.out.print("Cost: "); int cost2 = Integer.parseInt(scanner.nextLine());
                    System.out.print("Số ngày trước: "); int days = Integer.parseInt(scanner.nextLine());
                    System.out.print("Weight: "); double weight = Double.parseDouble(scanner.nextLine());
                    manager.add(new Meat(id2, name2, LocalDate.now().minusDays(days), cost2, weight));
                    break;

                case 3:
                    System.out.print("Nhập ID muốn sửa: ");
                    String id3 = scanner.nextLine();
                    System.out.print("1. Bột hay 2. Thịt? ");
                    int type = Integer.parseInt(scanner.nextLine());
                    if (type == 1) {
                        System.out.print("Tên: "); String name = scanner.nextLine();
                        System.out.print("Cost: "); int cost = Integer.parseInt(scanner.nextLine());
                        System.out.print("Số tháng trước: "); int m = Integer.parseInt(scanner.nextLine());
                        System.out.print("Quantity: "); int q = Integer.parseInt(scanner.nextLine());
                        manager.update(id3, new CrispyFlour(id3, name, LocalDate.now().minusMonths(m), cost, q));
                    } else {
                        System.out.print("Tên: "); String name = scanner.nextLine();
                        System.out.print("Cost: "); int cost = Integer.parseInt(scanner.nextLine());
                        System.out.print("Số ngày trước: "); int d = Integer.parseInt(scanner.nextLine());
                        System.out.print("Weight: "); double w = Double.parseDouble(scanner.nextLine());
                        manager.update(id3, new Meat(id3, name, LocalDate.now().minusDays(d), cost, w));
                    }
                    break;

                case 4:
                    System.out.print("Nhập ID muốn xóa: ");
                    String id4 = scanner.nextLine();
                    manager.remove(id4);
                    break;

                case 5:
                    manager.showAll();
                    break;

                case 6:
                    System.out.println("Tổng giá gốc: " + manager.getTotalAmount());
                    System.out.println("Tổng sau chiết khấu: " + manager.getTotalDiscounted());
                    System.out.println("Chênh lệch: " + manager.getDifference());
                    break;

                case 0:
                    System.out.println("Thoát.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }

        } while (choice != 0);

    }
}
