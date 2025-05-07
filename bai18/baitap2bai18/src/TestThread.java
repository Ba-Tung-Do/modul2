public class TestThread {

    // Lớp in số lẻ (1, 3, 5, ..., 9)
    static class OddThread extends Thread {
        @Override
        public void run() {
            for (int i = 1; i <= 10; i += 2) {
                System.out.println("Số lẻ: " + i);
                try {
                    Thread.sleep(10); // ngủ 10ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Lớp in số chẵn (2, 4, 6, ..., 10)
    static class EvenThread extends Thread {
        @Override
        public void run() {
            for (int i = 2; i <= 10; i += 2) {
                System.out.println("Số chẵn: " + i);
                try {
                    Thread.sleep(15); // ngủ 15ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Phương thức main
    public static void main(String[] args) {
        OddThread odd = new OddThread();
        EvenThread even = new EvenThread();

        // Bắt đầu thread in số lẻ
        odd.start();

        try {
            // Chờ in xong số lẻ rồi mới in số chẵn
            odd.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Bắt đầu thread in số chẵn
        even.start();
    }
}
