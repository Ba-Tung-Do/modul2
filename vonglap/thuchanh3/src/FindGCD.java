import java.util.Scanner;

public class FindGCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số nguyên a: ");
        int a = sc.nextInt();

        System.out.print("Nhập số nguyên b: ");
        int b = sc.nextInt();

        // Đảm bảo giá trị dương
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        System.out.println("Ước số chung lớn nhất (UCLN) là: " + a);

        sc.close();
    }
}
