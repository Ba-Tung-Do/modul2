

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5);
        shapes[1] = new Square(7);
        shapes[2] = new Rectangle(4,6);

        for (Shape shape : shapes) {
            System.out.println("Dien tich: " + shape.getArea());
            if (shape instanceof Colorable){
                ((Colorable) shape ).howToColor();
            }
            System.out.println("-----------");
        }
    }
}