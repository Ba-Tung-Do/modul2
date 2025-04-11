import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số phần tử của mảng: ");
        int size = scanner.nextInt();

        int[] array = new int[size];

        // Nhập từng phần tử vào mảng
        for (int i = 0; i < size; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        // Gọi hàm tìm giá trị nhỏ nhất
        int min = findMin(array);

        System.out.println("Giá trị nhỏ nhất trong mảng là: " + min);
        scanner.close();
    }

    // Hàm tìm giá trị nhỏ nhất trong mảng
    public static int findMin(int[] array) {
        int min = array[0];  // Giả sử phần tử đầu tiên là nhỏ nhất

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }
}
