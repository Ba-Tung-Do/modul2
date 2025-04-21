import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<NhanVien> danhSach = new ArrayList<>();
        danhSach.add(new NhanVienFullTime("01","Nguyen Van A",20,"@example1","76756767",50000,1000000,500000));
        danhSach.add(new NhanVienFullTime("02","Nguyen Van b",20,"@example1","76756767",50000,1000000,500000));
        danhSach.add(new NhanVienFullTime("03","Nguyen Van C",20,"@example1","76756767",50000,1000000,500000));
        danhSach.add(new NhanVienPartTime("04","Nguyen van E",24,"@example4","123456",50000));
        danhSach.add(new NhanVienPartTime("05","Nguyen van F",24,"@example4","123456",50000));
        danhSach.add(new NhanVienPartTime("06","Nguyen van G",24,"@example4","123456",50000));

        for (NhanVien nv : danhSach) {
            System.out.println(nv);
        }
    }






}