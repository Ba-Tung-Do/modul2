public class NumberGenerator implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Thread: " + Thread.currentThread().getName()
                    + ", HashCode: " + this.hashCode()
                    + ", Number: " + i);
            try {
                Thread.sleep(500); // Dừng 500ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
