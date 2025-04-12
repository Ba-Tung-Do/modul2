public class Rectangle {
    double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    public double getArea() {
        return width * height;
    }
    public double getPerimeter() {
        return 2 * width + 2 * height;
    }
    public String display() {
        return "Rectangle: width=" + width + ", height=" + height + "\n";
    }
}
