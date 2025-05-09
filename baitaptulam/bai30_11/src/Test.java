import java.util.ArrayList;
import java.util.Collections;

public class Test {
    public static void main(String[] args) {
        ArrayList<SanPham> ds = new ArrayList<>();
        SanPham sp1 = new SanPham(1, "samsung",1050);
        SanPham sp2 = new SanPham(2, "iphone",500);
        SanPham sp3 = new SanPham(3, "hocamdao",800);

        ds.add(sp1);
        ds.add(sp2);
        ds.add(sp3);

        for (SanPham sp : ds) {
            System.out.println(sp);
        }

        Collections.sort(ds);
        System.out.println("danh sach san pham sau sap xep la :");
        for (SanPham sp: ds) {
            System.out.println(sp);
        }
    }
}
