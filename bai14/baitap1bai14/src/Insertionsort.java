public class Insertionsort {

    // Khởi tạo mảng double với các phần tử cần sắp xếp
    static double[] list = {1, 9, 4.5, 6.6, 5.7, -4.5, 8, 8, 88};

    // Phương thức sắp xếp chèn (insertion sort)
    public static void insertionSort(double[] array) {
        int pos;        // Vị trí sẽ dùng để dịch phần tử về phía trước
        double x;       // Biến tạm để lưu giá trị đang xét

        // Bắt đầu từ phần tử thứ 2 (vì phần tử đầu tiên coi như đã được sắp xếp)
        for (int i = 1; i < array.length; i++) {
            x = array[i];       // Gán giá trị cần chèn
            pos = i;            // Ghi nhớ vị trí hiện tại

            // Dịch chuyển các phần tử lớn hơn x về phía sau
            while (pos > 0 && x < array[pos - 1]) {
                array[pos] = array[pos - 1];  // Dịch phần tử về sau một ô
                pos--;                        // Giảm vị trí xuống để tiếp tục so sánh phần tử trước đó
            }
            array[pos] = x;     // Chèn x vào đúng vị trí
        }
    }
    // Phương thức main để chạy chương trình
    public static void main(String[] args) {
        insertionSort(list);  // Gọi hàm sắp xếp
        // In ra mảng sau khi đã sắp xếp
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
    }
}
