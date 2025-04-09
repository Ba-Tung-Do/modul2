import  java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so luong so nguyen to can in ra :  ");
        int number = sc.nextInt();

        int count = 0;
        int n = 2;

        while (count < number) {
            if (isPrime(n)) {
                System.out.print(n + " ");
                count++;
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
