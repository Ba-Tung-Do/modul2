public class InsertionSort {
    public static void insertionSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int currentElement = list[i];
            int k = i - 1;

            // Dịch các phần tử lớn hơn currentElement sang phải
            while (k >= 0 && list[k] > currentElement) {
                list[k + 1] = list[k]; // Dịch sang phải
                k--;
            }

            // Chèn currentElement vào vị trí đúng
            list[k + 1] = currentElement;
        }
    }
    public static void main(String[] args) {
        int[] list = {5, 2, 9, 1, 3, 6};
        System.out.println("Trước khi sắp xếp:");
        for (int i : list) {
            System.out.print(i + " ");
        }
        insertionSort(list);
        System.out.println("\nSau khi sắp xếp:");
        for (int i : list) {
            System.out.print(i + " ");
        }
    }
}
