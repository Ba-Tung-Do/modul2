import java.util.Scanner;

public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập loại hình (circle / rectangle / square): ");
        String type = scanner.nextLine();

        Shape shape = shapeFactory.getShape(type);

        if (shape != null) {
            shape.draw();
        } else {
            System.out.println("Không nhận diện được hình.");
        }
    }
}
