public class SelectionSort {
    static double[] list = {1, 9, 4.5, 6.6, 5.7, -4.5};
    public static void selectionSort(double[] list) {
        // Vòng lặp ngoài: chọn từng vị trí i để đặt phần tử nhỏ nhất vào
        for (int i = 0; i < list.length - 1; i++) {
            // Giả định phần tử nhỏ nhất nằm ở vị trí i
            double currentMin = list[i];
            int currentMinIndex = i;
            // Tìm phần tử nhỏ nhất từ i+1 đến cuối mảng
            for (int j = i + 1; j < list.length; j++) {
                if (currentMin > list[j]) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }
    public static void main(String[] args) {
        selectionSort(list);
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }
}
