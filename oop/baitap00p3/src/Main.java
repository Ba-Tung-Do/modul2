import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[100000];
        Random rand = new Random();

        // Tạo mảng ngẫu nhiên
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100000);
        }

        // Khởi tạo đồng hồ
        StopWatch stopwatch = new StopWatch();
        stopwatch.start(); // Bắt đầu đếm thời gian

        // Thuật toán sắp xếp chọn (Selection Sort)
        selectionSort(arr);

        stopwatch.stop(); // Kết thúc đo thời gian

        System.out.println("Thời gian thực hiện thuật toán (ms): " + stopwatch.getElapsedTime());
    }

    // Selection sort
    public static void selectionSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // Hoán đổi phần tử nhỏ nhất với phần tử tại vị trí i
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}
