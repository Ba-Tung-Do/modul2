import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchRecursive {

    // Hàm tìm kiếm nhị phân bằng đệ quy
    public static int binarySearch(int[] array, int left, int right, int value) {
        if (left > right) {
            return -1; // Không tìm thấy
        }

        int middle = (left + right) / 2;

        if (array[middle] == value) {
            return middle;
        } else if (value > array[middle]) {
            return binarySearch(array, middle + 1, right, value);
        } else {
            return binarySearch(array, left, middle - 1, value);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bước 1: Nhập mảng
        System.out.print("Nhập số phần tử của mảng: ");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Nhập " + n + " phần tử:");
        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        // Bước 2: Sắp xếp mảng
        Arrays.sort(array);
        System.out.println("Mảng sau khi sắp xếp: " + Arrays.toString(array));

        // Bước 3: Nhập giá trị cần tìm
        System.out.print("Nhập giá trị cần tìm: ");
        int value = scanner.nextInt();

        // Bước 4: Gọi hàm tìm kiếm nhị phân
        int index = binarySearch(array, 0, array.length - 1, value);

        if (index == -1) {
            System.out.println("Không tìm thấy giá trị " + value + " trong mảng.");
        } else {
            System.out.println("Giá trị " + value + " được tìm thấy tại vị trí index = " + index);
        }
    }
}
