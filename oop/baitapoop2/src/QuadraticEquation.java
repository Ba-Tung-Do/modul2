public class QuadraticEquation {
    private double a, b, c;

    public QuadraticEquation(double a ,double b, double c){
    this.a = a;
    this.b = b;
    this.c = c;
    }
    public double getDiscriminant() {
    return b * b - 4 * a * c;
    }
    public double getRoot1() {
        double delta = getDiscriminant();
        if (delta < 0) {
            return Double.NaN;
        }
            return (-b + Math.sqrt(delta)) / (2 * a);

    }
    public double getRoot2(){
        double delta = getDiscriminant();
        if (delta < 0) {
            return Double.NaN;
        }
            return (-b - Math.sqrt(delta)) / (2 * a);
    }
    public void displayRoots() {
        double delta = getDiscriminant();
        if (delta < 0) {
            System.out.println("Phuong trinh vo nghiem");
        } else if (delta == 0){
            System.out.println("Phuong trinh 2 kiem kep x = " + getRoot1());

        } else {
            System.out.println("Phuong trinh co 2 nghiem  ");
            System.out.println("x1 = " + getRoot1());
            System.out.println("x2 = " + getRoot2());
        }
    }


}