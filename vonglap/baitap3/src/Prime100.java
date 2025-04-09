import  java.util.Scanner;

public class Prime100 {
    public static void main(String[] args) {
        int n = 2;
        System.out.println("Cac so nguyen to nho hon 100 la : ");

        while (n <= 100) {
        if (isPrime(n)) {
            System.out.println(n + " ");
        }
        n++;
        }
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
