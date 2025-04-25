public class SelectionSort {
    static double[] list = {1, 9, 4.5, 6.6, 5.7, -4.5};

    public static void selectionSort(double[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            /* vong lap dau tien tim phan tu min */
            double currentMin = list[i];  // gan min bang phan tu i
            int currentMinIndex = i;// gan vi tri min la index i

            for (int j = i + 1; j < list.length; j++) { // chay vong lap neu thay phan tu nho hon thi cap nhat vi tri
                if (currentMin > list[j]) {
                    currentMin = list[j];
                    currentMinIndex = j; // doi vi tri min
                }
            }

            /* neu tim duoc phan tu nho hon phan tu ban dau , doi cho  */
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
