import java.util.Scanner;

public class TongCheoChinh {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bước 1: Nhập kích thước ma trận vuông
        int size;
        do {
            System.out.print("Nhập kích thước ma trận vuông (>=1): ");
            size = scanner.nextInt();
        } while (size < 1);

        double[][] matrix = new double[size][size];

        // Bước 2: Nhập các phần tử của ma trận
        System.out.println("Nhập các phần tử của ma trận:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("Phần tử [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextDouble();
            }
        }

        // Bước 3: Tính tổng đường chéo chính (i == j)
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }

        // Bước 4: In kết quả
        System.out.println("Tổng các phần tử ở đường chéo chính là: " + sum);
    }
}
