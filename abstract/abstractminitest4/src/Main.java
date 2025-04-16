import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Personnel[] danhSachNV = new Personnel[100];
    static int count = 0;

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("Admin management system");
            System.out.println("1. Thêm nhân viên fulltime");
            System.out.println("2. Thêm nhân viên parttime");
            System.out.println("3. Hiển thị danh sách nhân viên");
            System.out.println("4. Tính lương trung bình");
            System.out.println("5. Liệt kê nhân viên fulltime lương dưới trung bình");
            System.out.println("6. Tính tổng lương parttime");
            System.out.println("7. Sắp xếp nhân viên fulltime theo lương tăng dần");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    themFulltime();
                    break;
                case 2:
                    themParttime();
                    break;
                case 3:
                    hienThi();
                    break;
                case 4:
                    tinhLuongTrungBinh();
                    break;
                case 5:
                    lietKeFulltimeLuongThap();
                    break;
                case 6:
                    tongLuongParttime();
                    break;
                case 7:
                    sapXepFulltime();
                    break;
                case 0:
                    System.out.println(" Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }


    static void themFulltime() {
        System.out.print("Mã NV: ");
        String ma = scanner.nextLine();
        System.out.print("Họ tên: ");
        String ten = scanner.nextLine();
        System.out.print("Tuổi: ");
        int tuoi = Integer.parseInt(scanner.nextLine());
        System.out.print("SĐT: ");
        String sdt = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Lương cứng: ");
        double luongCung = Double.parseDouble(scanner.nextLine());
        System.out.print("Tiền thưởng: ");
        double thuong = Double.parseDouble(scanner.nextLine());
        System.out.print("Tiền phạt: ");
        double phat = Double.parseDouble(scanner.nextLine());

        danhSachNV[count++] = new PersonnelFullTime(ma, ten, tuoi, sdt, email, luongCung, thuong, phat);
        System.out.println(" Thêm fulltime thành công.");
    }

    static void themParttime() {
        System.out.print("Mã NV: ");
        String ma = scanner.nextLine();
        System.out.print("Họ tên: ");
        String ten = scanner.nextLine();
        System.out.print("Tuổi: ");
        int tuoi = Integer.parseInt(scanner.nextLine());
        System.out.print("SĐT: ");
        String sdt = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Số giờ làm việc: ");
        int gio = Integer.parseInt(scanner.nextLine());

        danhSachNV[count++] = new PersonnelPassTime(ma, ten, tuoi, sdt, email, gio);
        System.out.println("Thêm parttime thành công.");
    }

    static void hienThi() {
        if (count == 0) {
            System.out.println(" Danh sách rỗng.");
            return;
        }
        System.out.println("===== DANH SÁCH NHÂN VIÊN =====");
        for (int i = 0; i < count; i++) {
            System.out.println(danhSachNV[i]);
        }
    }

    static void tinhLuongTrungBinh() {
        if (count == 0) return;
        double tong = 0;
        for (int i = 0; i < count; i++) {
            tong += danhSachNV[i].tinhLuong();
        }
        double tb = tong / count;
        System.out.println("Lương trung bình: " + tb);
    }

    static void lietKeFulltimeLuongThap() {
        if (count == 0) return;
        double tong = 0;
        for (int i = 0; i < count; i++) {
            tong += danhSachNV[i].tinhLuong();
        }
        double tb = tong / count;

        System.out.println("Fulltime lương < TB:");
        for (int i = 0; i < count; i++) {
            if (danhSachNV[i] instanceof PersonnelFullTime && danhSachNV[i].tinhLuong() < tb) {
                System.out.println(danhSachNV[i]);
            }
        }
    }

    static void tongLuongParttime() {
        double tong = 0;
        for (int i = 0; i < count; i++) {
            if (danhSachNV[i] instanceof PersonnelPassTime) {
                tong += danhSachNV[i].tinhLuong();
            }
        }
        System.out.println("Tổng lương parttime: " + tong);
    }

    static void sapXepFulltime() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (danhSachNV[i] instanceof PersonnelFullTime &&
                        danhSachNV[j] instanceof PersonnelFullTime &&
                        danhSachNV[i].tinhLuong() > danhSachNV[j].tinhLuong()) {
                    Personnel temp = danhSachNV[i];
                    danhSachNV[i] = danhSachNV[j];
                    danhSachNV[j] = temp;
                }
            }
        }

        System.out.println("Danh sách fulltime sau khi sắp xếp tăng dần:");
        for (int i = 0; i < count; i++) {
            if (danhSachNV[i] instanceof PersonnelFullTime) {
                System.out.println(danhSachNV[i]);
            }
        }
    }
}
