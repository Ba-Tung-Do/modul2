import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VehicleManager manager = new VehicleManager();// khai bao doi tuong ob cua class
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n Vehicle Management System ");
            System.out.println("1. Them phuong tien");
            System.out.println("2. Xoa phuong tien theo ma");
            System.out.println("3. Hien thi danh sach phuong tien");
            System.out.println("4. Hien thi bao cao thue");
            System.out.println("5. Sap xep theo nam san xuat");
            System.out.println("6. Sap xep theo hang san xuat");
            System.out.println("7. Sap xep theo thue tang dan");
            System.out.println("8. Xem lich su thao tac");
            System.out.println("9. Hien thi thue cua phuong tien theo ID");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon cua ban: ");


            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) { // goi phuong thuc va truyen tham so
                case 1:
                    addVehicle(manager, scanner);
                    break;
                case 2:
                    removeVehicle(manager, scanner);
                    break;
                case 3:
                    manager.displayAllVehicles();
                    break;
                case 4:
                    manager.displayTaxReport();
                    break;
                case 5:
                    manager.sortByYear();
                    break;
                case 6:
                    manager.sortByBrand();
                    break;
                case 7:
                    manager.sortByTax();
                    break;
                case 8:
                    manager.printHistory();
                    break;
                case 9:
                    displayTaxById(manager,scanner);
                    break;
                case 0:
                    System.out.println("Chuong trinh ket thuc. Tam biet!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Hay chon lai.");
            }

        } while (choice != 0);

        scanner.close();
    }

    private static void addVehicle(VehicleManager manager, Scanner scanner) {
        System.out.print("Chon loai phuong tien (1: Xe máy  2: Ô tô): ");
        int type = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhap ID: ");
        String id = scanner.nextLine();
        System.out.print("Nhap hang: ");
        String brand = scanner.nextLine();
        System.out.print("Nhap nam san xuat: ");
        int year = Integer.parseInt(scanner.nextLine());

        if (type == 1) {
            System.out.print("Nhap cong suat dong co (engine power): ");
            int enginePower = Integer.parseInt(scanner.nextLine());
            manager.addVehicle(new Motorbike(id, brand, year, enginePower));
            System.out.println("Them xe may thanh cong!");
        } else if (type == 2) {
            System.out.print("Nhap so cho ngoi (number of seats): ");
            int seats = Integer.parseInt(scanner.nextLine());
            manager.addVehicle(new Car(id, brand, year, seats));
            System.out.println("Them o to thanh cong!");
        } else {
            System.out.println("Loai phuong tien khong hop le!");
        }
    }

    private static void removeVehicle(VehicleManager manager, Scanner scanner) {
        System.out.print("Nhap ID phuong tien can xoa: ");
        String removeId = scanner.nextLine();
        boolean success = manager.removeVehicle(removeId);
        if (success) {
            System.out.println("Da xoa phuong tien co ID: " + removeId);
        } else {
            System.out.println("Khong tim thay phuong tien voi ID: " + removeId);
        }
    }
    private static void displayTaxById(VehicleManager manager, Scanner scanner) {
        System.out.print("Nhap ID phuong tien can tinh thue : ");
        String id = scanner.nextLine();
        manager.displayTaxiById(id);
    }
}
