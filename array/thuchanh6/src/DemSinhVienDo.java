import java.util.Scanner;

public class DemSinhVienDo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] diem = new double[30]; // Mảng chứa điểm tối đa 30 sinh viên
        int soLuong;

        // Nhập số lượng sinh viên
        do {
            System.out.print("Nhập số lượng sinh viên (tối đa 30): ");
            soLuong = scanner.nextInt();
        } while (soLuong < 1 || soLuong > 30);

        // Nhập điểm cho từng sinh viên
        for (int i = 0; i < soLuong; i++) {
            do {
                System.out.print("Nhập điểm sinh viên thứ " + (i + 1) + ": ");
                diem[i] = scanner.nextDouble();
            } while (diem[i] < 0 || diem[i] > 10);
        }

        // Đếm số sinh viên đỗ
        int demDo = 0;
        for (int i = 0; i < soLuong; i++) {
            if (diem[i] >= 5.0) {
                demDo++;
            }
        }

        // Xuất kết quả
        System.out.println("Số lượng sinh viên đỗ: " + demDo);
    }
}
