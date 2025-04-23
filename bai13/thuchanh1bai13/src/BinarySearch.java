public class BinarySearch {
    static int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};

    static int binarySearch(int[] list, int key) {
        int low = 0;
        int high = list.length - 1;
        while (high >= low) {
            int mid = (low + high) / 2;
            if (key < list[mid]) {
                high = mid - 1;
            } else if (key == list[mid]) {
                return mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        printResult(2);   // index 0
        printResult(11);  // index 4
        printResult(79);  // index 12
        printResult(1);   // không có phần tử
        printResult(5);   // không có phần tử
        printResult(80);  // không có phần tử
    }

    static void printResult(int key) {
        int result = binarySearch(list, key);
        if (result == -1) {
            System.out.println("Không có phần tử: " + key);
        } else {
            System.out.println("Tìm thấy phần tử " + key + " tại vị trí: " + result);
        }
    }
}
