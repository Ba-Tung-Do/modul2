import java.util.*;

public class ShoppingCart {
    private List<Product> danhSach = new ArrayList<>();

    public void them(Product sp) {
        danhSach.add(sp);
    }

    public List<Product> getDanhSach() {
        return danhSach;
    }

    public double tinhTongTien() {
        return danhSach.stream().mapToDouble(Product::getGia).sum();
    }

    public void hienThi() {
        for (Product sp : danhSach) {
            System.out.println(sp);
        }
    }
}
