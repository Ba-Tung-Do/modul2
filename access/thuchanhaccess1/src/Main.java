public class Main {
    public static void main(String args[]) {

        // khoi tao doi tuong
        Student s1 = new Student(111, "Hoang");
        Student s2 = new Student(222, "Khanh");
        Student s3 = new Student(333, "Nam");

        // goi phuong thuc hien thi
        s1.display();
        Student.change(); // goi phuong thuc chang

        s2.display();
        s3.display();
    }
}