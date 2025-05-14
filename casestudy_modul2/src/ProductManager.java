import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private static List<Product> danhSachSP = new ArrayList<>();

    public static void themSanPham(Product sp) {
        danhSachSP.add(sp);
        luuFile();
    }

    public static List<Product> getDanhSachSP() {
        return danhSachSP;
    }

    public static void luuFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("sanpham.dat"))) {
            oos.writeObject(danhSachSP);
        } catch (IOException e) {
            System.out.println("Lỗi lưu sản phẩm: " + e.getMessage());
        }
    }

    public static void taiFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("sanpham.dat"))) {
            danhSachSP = (List<Product>) ois.readObject();
        } catch (Exception e) {
            danhSachSP = new ArrayList<>(); // nếu file chưa tồn tại
        }
    }
}
