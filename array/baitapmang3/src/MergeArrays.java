import java.util.Scanner;

public class MergeArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bước 1: Nhập mảng 1
        System.out.print("Nhập số phần tử của mảng 1: ");
        int size1 = scanner.nextInt();
        int[] array1 = new int[size1];
        for (int i = 0; i < size1; i++) {
            System.out.print("Nhập phần tử array1[" + i + "]: ");
            array1[i] = scanner.nextInt();
        }

        // Bước 2: Nhập mảng 2
        System.out.print("Nhập số phần tử của mảng 2: ");
        int size2 = scanner.nextInt();
        int[] array2 = new int[size2];
        for (int i = 0; i < size2; i++) {
            System.out.print("Nhập phần tử array2[" + i + "]: ");
            array2[i] = scanner.nextInt();
        }

        // Bước 3: Tạo mảng thứ 3 có kích thước bằng size1 + size2
        int[] mergedArray = new int[size1 + size2];

        // Bước 4: Sao chép mảng 1 vào mergedArray
        for (int i = 0; i < size1; i++) {
            mergedArray[i] = array1[i];
        }

        // Bước 5: Sao chép mảng 2 vào mergedArray (bắt đầu từ index = size1)
        for (int i = 0; i < size2; i++) {
            mergedArray[size1 + i] = array2[i];
        }

        // In mảng sau khi gộp
        System.out.println("Mảng sau khi gộp là:");
        for (int num : mergedArray) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}
