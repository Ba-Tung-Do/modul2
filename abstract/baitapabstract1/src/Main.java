import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(4, 6);
        shapes[2] = new Square(7);

        Random random = new Random();

        for (Shape shape : shapes) {
            System.out.println("Diện tích trước resize: " + shape.getArea());
            if (shape instanceof Resizeable) {
                double percent = random.nextInt(100) + 1; // 1% -> 100%
                System.out.println("Resize với tỉ lệ: " + percent + "%");
                ((Resizeable) shape).resize(percent);
                System.out.println("Diện tích sau resize: " + shape.getArea());
            }
            System.out.println("-----------------------------");
        }
    }
}
