public class Main {
    public static void main(String[] args) {
        Point2D point2D = new Point2D(3.5f, 4.5f);
        System.out.println("Point2D: " + point2D);
        System.out.println("XY array: " + java.util.Arrays.toString(point2D.getXY()));

        Point3D point3D = new Point3D(1.2f, 3.4f, 5.6f);
        System.out.println("Point3D: " + point3D);
        System.out.println("XYZ array: " + java.util.Arrays.toString(point3D.getXYZ()));
    }
}
