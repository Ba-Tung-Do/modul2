import java.util.Scanner;

public class TriangleChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Nhap vao canh a :");
            double a = scanner.nextDouble();
            System.out.println("Nhap vao canh b :");
            double b = scanner.nextDouble();
            System.out.println("Nhap vao canh c :");
            double c = scanner.nextDouble();

            checkTriangle(a,b,c);
            System.out.println("Day la mot tam giac hop le !");
        } catch (IllegalTriangleException e) {
            System.out.println("loi : "+ e.getMessage());
        } catch (Exception e) {
            System.out.println("Loi nhap lieu ");
        }
    }
    public static void checkTriangle(double a, double b, double c) throws IllegalTriangleException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalTriangleException("Các cạnh phải lớn hơn 0!");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalTriangleException("Tổng hai cạnh phải lớn hơn cạnh còn lại!");
        }
    }
}
