import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomerManager {
    private static List<Account> danhSachTK = new ArrayList<>();

    public static void themKhachHang(Account kh) {
        danhSachTK.add(kh);
        luuFile();
    }

    public static void capNhatTuMap(Map<String, Account> map) {
        danhSachTK = new ArrayList<>(map.values());
        luuFile();
    }

    public static void luuFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("khachhang.dat"))) {
            oos.writeObject(danhSachTK);
        } catch (IOException e) {
            System.out.println("Lỗi khi lưu danh sách khách hàng: " + e.getMessage());
        }
    }

    public static void taiFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("khachhang.dat"))) {
            danhSachTK = (List<Account>) ois.readObject();
        } catch (Exception e) {
            danhSachTK = new ArrayList<>(); // nếu chưa có file
        }
    }

    public static List<Account> getdanhSachTK() {
        return danhSachTK;
    }
}
