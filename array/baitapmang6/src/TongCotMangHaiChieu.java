import java.util.Scanner;

public class TongCotMangHaiChieu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bước 1: Nhập kích thước mảng
        System.out.print("Nhập số hàng: ");
        int rows = scanner.nextInt();
        System.out.print("Nhập số cột: ");
        int cols = scanner.nextInt();

        // Khai báo và nhập mảng
        double[][] matrix = new double[rows][cols];
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Phần tử [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextDouble();
            }
        }

        // Bước 2: Nhập chỉ số cột cần tính tổng
        int columnIndex;
        do {
            System.out.print("Nhập chỉ số cột cần tính tổng (0 đến " + (cols - 1) + "): ");
            columnIndex = scanner.nextInt();
        } while (columnIndex < 0 || columnIndex >= cols);

        // Bước 3: Tính tổng các phần tử của cột
        double sum = 0;
        for (int i = 0; i < rows; i++) {
            sum += matrix[i][columnIndex];
        }

        // Xuất kết quả
        System.out.println("Tổng của cột " + columnIndex + " là: " + sum);
    }
}
