public class Student {
    private int rollno;
    private String name;
    private static String college = "BBDIT";

    //constructor khoi tao bien
    Student(int r, String n) {
        rollno = r;
        name = n;
    }

    //phuong thuc tinh de thay doi gia tri cua bien tinh
    static void change() {
        college = "CODEGYM";
    }

    // hien thi ra man hinh
    void display() {
        System.out.println(rollno + " " + name + " " + college);
    }
}