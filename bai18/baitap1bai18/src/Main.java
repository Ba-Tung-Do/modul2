public class Main {
    public static void main(String[] args) {
        NumberGenerator generator1 = new NumberGenerator();
        NumberGenerator generator2 = new NumberGenerator();

        Thread thread1 = new Thread(generator1);
        Thread thread2 = new Thread(generator2);

        // Đặt tên cho thread để dễ quan sát
        thread1.setName("Generator-1");
        thread2.setName("Generator-2");

        // Thay đổi độ ưu tiên
        thread1.setPriority(Thread.MAX_PRIORITY); // 10
        thread2.setPriority(Thread.MIN_PRIORITY); // 1

        // Bắt đầu chạy
        thread1.start();
        thread2.start();
    }
}
