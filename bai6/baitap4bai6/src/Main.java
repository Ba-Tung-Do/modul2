import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập độ dài 3 cạnh
        System.out.print("Nhập cạnh thứ nhất: ");
        double a = scanner.nextDouble();
        System.out.print("Nhập cạnh thứ hai: ");
        double b = scanner.nextDouble();
        System.out.print("Nhập cạnh thứ ba: ");
        double c = scanner.nextDouble();

        scanner.nextLine(); // clear buffer

        // Nhập màu
        System.out.print("Nhập màu sắc của tam giác: ");
        String color = scanner.nextLine();

        // Nhập trạng thái fill
        System.out.print("Tam giác có được tô màu không? (true/false): ");
        boolean filled = scanner.nextBoolean();

        // Tạo đối tượng Triangle
        Triangle triangle = new Triangle(a, b, c);
        triangle.setColor(color);
        triangle.setFilled(filled);

        // Hiển thị thông tin tam giác
        System.out.println("\n--- THÔNG TIN TAM GIÁC ---");
        System.out.println(triangle.toString());
        System.out.println("Color: " + triangle.getColor());
        System.out.println("Filled: " + triangle.isFilled());
        System.out.println("Perimeter: " + triangle.getPerimeter());
        System.out.println("Area: " + triangle.getArea());
    }
}
