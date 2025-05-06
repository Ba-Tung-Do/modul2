import java.util.Scanner;

public class DemKyTuTrongChuoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bước 1: Khai báo chuỗi
        System.out.print("Nhập chuỗi: ");
        String chuoi = scanner.nextLine();

        // Bước 2: Nhập ký tự cần đếm
        System.out.print("Nhập ký tự cần đếm: ");
        char kyTu = scanner.next().charAt(0);

        // Bước 3: Khởi tạo biến đếm
        int count = 0;

        // Bước 4: Duyệt từng ký tự trong chuỗi
        for (int i = 0; i < chuoi.length(); i++) {
            if (chuoi.charAt(i) == kyTu) {
                count++;
            }
        }

        // Bước 5: In kết quả
        System.out.println("Số lần xuất hiện của ký tự '" + kyTu + "' là: " + count);
    }
}
