import java.util.Scanner;

public class InsertToArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = new int[10]; // Mảng cố định 10 phần tử
        int size = 5; // Giả sử ban đầu có 5 phần tử

        // Khởi tạo mảng ban đầu
        array[0] = 10;
        array[1] = 4;
        array[2] = 6;
        array[3] = 7;
        array[4] = 8;

        System.out.print("Nhập giá trị cần chèn: ");
        int value = scanner.nextInt();

        System.out.print("Nhập vị trí cần chèn (0 đến " + size + "): ");
        int index = scanner.nextInt();

        if (index < 0 || index > size || size >= array.length) {
            System.out.println("Không thể chèn phần tử.");
        } else {
            // Dịch các phần tử sang phải
            for (int i = size; i > index; i--) {
                array[i] = array[i - 1];
            }

            // Gán phần tử mới vào vị trí
            array[index] = value;
            size++; // Tăng số lượng phần tử

            // In mảng sau khi chèn
            System.out.println("Mảng sau khi chèn:");
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + "\t");
            }
        }

        scanner.close();
    }
}
