import java.io.*;

public class Invoice {
    public static void inHoaDon(ShoppingCart gio, String stkKH, String stkShop, boolean thanhCong) {
        if (!thanhCong) {
            System.out.println("Thanh toán thất bại. Không in hóa đơn.");
            return;
        }
        try (FileWriter fw = new FileWriter("hoadon.txt")) {
            fw.write("===== HÓA ĐƠN THANH TOÁN =====\n");
            for (Product  sp : gio.getDanhSach()) {
                fw.write(sp.toString() + "\n");
            }
            fw.write("------------------------------\n");
            fw.write("Tổng tiền: " + gio.tinhTongTien() + " VNĐ\n");
            fw.write("Số tài khoản KH: " + stkKH + "\n");
            fw.write("Số tài khoản shop: " + stkShop + "\n");
            fw.write("==============================\n");
            System.out.println("Đã in hóa đơn thành công.");
        } catch (IOException e) {
            System.out.println("Lỗi ghi file hóa đơn: " + e.getMessage());
        }
    }
}
