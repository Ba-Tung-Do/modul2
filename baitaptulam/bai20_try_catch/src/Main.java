public class Main {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;

        try {
            int c= a/b;
            System.out.println("c =" + c);
        }
        catch (ArithmeticException e) {
            System.out.println("Co loi toan hoc trong du lieu nhap vao roi ");
        }
        catch (Exception e) {
            System.out.println(" co loi roi ");
        }
        finally {
            System.out.println(" tiep tuc nhap du lieu nhe : ");
        }
    }
}