import java.util.Scanner;

public class MaxIn2DArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập kích thước ma trận
        System.out.print("Nhập số dòng: ");
        int rows = scanner.nextInt();

        System.out.print("Nhập số cột: ");
        int cols = scanner.nextInt();

        // Khai báo mảng 2 chiều
        double[][] matrix = new double[rows][cols];

        // Nhập giá trị cho ma trận
        System.out.println("Nhập các phần tử của ma trận:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("matrix[" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextDouble();
            }
        }

        // Khởi tạo giá trị lớn nhất và vị trí ban đầu
        double max = matrix[0][0];
        int maxRow = 0;
        int maxCol = 0;

        // Duyệt để tìm phần tử lớn nhất
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        // In kết quả
        System.out.println("Phần tử lớn nhất là: " + max);
        System.out.println("Tọa độ: dòng " + maxRow + ", cột " + maxCol);

        scanner.close();
    }
}
