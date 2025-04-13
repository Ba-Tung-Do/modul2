import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("nhap vao a : ");
        double a = scanner.nextDouble();

        System.out.print("nhap vao b  :");
        double b = scanner.nextDouble();

        System.out.print("nhap vao c  :");
        double c = scanner.nextDouble();

        if (a==0){
            System.out.println("Khong phai phuong trinh bac 2");

        } else {
            QuadraticEquation pt = new QuadraticEquation(a, b, c);
            pt.displayRoots();
        }
    }
}