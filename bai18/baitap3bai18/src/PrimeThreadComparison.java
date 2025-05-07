public class PrimeThreadComparison {
    public static void main(String[] args) {
        Thread lazyThread = new Thread(new LazyPrimeFactorization());
        Thread optimizedThread = new Thread(new OptimizedPrimeFactorization());

        lazyThread.setPriority(Thread.MIN_PRIORITY);      // Ưu tiên thấp
        optimizedThread.setPriority(Thread.MAX_PRIORITY); // Ưu tiên cao

        lazyThread.start();
        optimizedThread.start();
    }
}

// Thuật toán kiểm tra nguyên tố chưa tối ưu
class LazyPrimeFactorization implements Runnable {
    @Override
    public void run() {
        int number = 2;
        while (true) {
            if (isPrime(number)) {
                System.out.println("Lazy found prime: " + number);
            }
            number++;
        }
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

// Thuật toán kiểm tra nguyên tố tối ưu (tới căn bậc hai)
class OptimizedPrimeFactorization implements Runnable {
    @Override
    public void run() {
        int number = 2;
        while (true) {
            if (isPrime(number)) {
                System.out.println("Optimized found prime: " + number);
            }
            number++;
        }
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
