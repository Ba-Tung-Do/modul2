import java.util.*;
import java.io.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Map<String, Account> danhSachTK = new HashMap<>();

    public static void main(String[] args) {
        CustomerManager.taiFile();
        ProductManager.taiFile();

        // Tạo sẵn các tài khoản quản trị
        danhSachTK.put("Admin01", new Account("Admin01", "A123456", "QuanLy", "999111"));
        danhSachTK.put("Admin02", new Account("Admin02", "A123456", "Kho", "999222"));
        danhSachTK.put("Admin03", new Account("Admin03", "A123456", "BanHang", "999333"));
        // Tạo sẵn 3 sản phẩm
        List<Product> list = ProductManager.getDanhSachSP();
        list.clear();
        list.add(new Product("P001", "Áo thun", 120000, "Áo thun cotton co giãn"));
        list.add(new Product("P002", "Quần jean", 250000, "Quần jean xanh nam nữ unisex"));
        list.add(new Product("P003", "Giày sneaker", 450000, "Giày sneaker thể thao, đế cao su"));
        ProductManager.luuFile();

        for (Account acc : CustomerManager.getdanhSachTK()) {
            danhSachTK.put(acc.getTenDangNhap(), acc);
        }

        while (true) {
            System.out.println("\n===== MENU HỆ THỐNG =====");
            System.out.println("1. Đăng ký tài khoản khách hàng");
            System.out.println("2. Đăng nhập");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            int chon = nhapSo();
            if (chon == 1) dangKy();
            else if (chon == 2) dangNhap();
            else break;
        }
    }

    static int nhapSo() {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (Exception e) {
            return -1;
        }
    }

    static void dangKy() {
        System.out.print("Tên đăng nhập: ");
        String ten = sc.nextLine();
        if (danhSachTK.containsKey(ten)) {
            System.out.println("Tài khoản đã tồn tại.");
            return;
        }
        System.out.print("Mật khẩu (bắt đầu bằng chữ in hoa, ít nhất 6 ký tự): ");
        String mk = sc.nextLine();
        if (!Account.hopLe(ten, mk)) {
            System.out.println("Tên hoặc mật khẩu không hợp lệ theo quy tắc.");
            return;
        }
        System.out.print("Số tài khoản ngân hàng: ");
        String stk = sc.nextLine();

        Account kh = new Account(ten, mk, "KhachHang", stk);
        danhSachTK.put(ten, kh);
        CustomerManager.capNhatTuMap(danhSachTK);
        System.out.println("Đăng ký thành công.");
    }

    static void dangNhap() {
        System.out.print("Tên đăng nhập: ");
        String ten = sc.nextLine();
        System.out.print("Mật khẩu: ");
        String mk = sc.nextLine();
        Account tk = danhSachTK.get(ten);
        if (tk == null || !tk.kiemTraDangNhap(ten, mk)) {
            System.out.println("Sai tên đăng nhập hoặc mật khẩu.");
            return;
        }

        switch (tk.getVaiTro()) {
            case "KhachHang": menuKhachHang(tk); break;
            case "QuanLy": menuQuanLy(tk); break;
            case "Kho": menuNhanVienKho(tk); break;
            case "BanHang": menuNhanVienBanHang(tk); break;
        }
    }

    static void menuKhachHang(Account kh) {
        ShoppingCart gio = new ShoppingCart();
        int chon;
        do {
            System.out.println("\n--- MENU KHÁCH HÀNG ---");
            System.out.println("1. Xem sản phẩm");
            System.out.println("2. Tìm sản phẩm");
            System.out.println("3. Thêm vào giỏ hàng");
            System.out.println("4. Thanh toán");
            System.out.println("5. Đổi mật khẩu");
            System.out.println("0. Quay lại");
            System.out.print("Chọn: ");
            chon = nhapSo();

            switch (chon) {
                case 1:
                    for (Product sp : ProductManager.getDanhSachSP()) System.out.println(sp);
                    break;
                case 2:
                    System.out.print("Từ khóa: ");
                    String kw = sc.nextLine();
                    for (Product sp : ProductManager.getDanhSachSP())
                        if (sp.getTenSP().toLowerCase().contains(kw.toLowerCase()))
                            System.out.println(sp);
                    break;
                case 3:
                    System.out.print("Nhập mã sản phẩm: ");
                    String ma = sc.nextLine();
                    boolean found = false;
                    for (Product sp : ProductManager.getDanhSachSP()) {
                        if (sp.getMaSP().equalsIgnoreCase(ma)) {
                            gio.them(sp);
                            System.out.println("Đã thêm vào giỏ hàng.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("Không tìm thấy sản phẩm.");
                    break;
                case 4:
                    System.out.println("Tiến hành thanh toán...");
                    boolean ok = Payment.xuLyThanhToan();
                    Invoice.inHoaDon(gio, kh.getSoTaiKhoan(), "SHOP123456", ok);
                    break;
                case 5:
                    System.out.print("Nhập mật khẩu mới: ");
                    String mkMoi = sc.nextLine();
                    if (Account.hopLe(kh.getTenDangNhap(), mkMoi)) {
                        kh.setMatKhau(mkMoi);
                        CustomerManager.capNhatTuMap(danhSachTK);
                        System.out.println("Đổi mật khẩu thành công.");
                    } else {
                        System.out.println("Mật khẩu không hợp lệ!");
                    }
                    break;
            }
        } while (chon != 0);
    }

    static void menuQuanLy(Account ql) {
        int chon;
        do {
            System.out.println("\n--- MENU QUẢN LÝ ---");
            System.out.println("1. Đổi mật khẩu đăng nhập");
            System.out.println("2. Đổi mật khẩu tài khoản khác");
            System.out.println("3. Quản lý sản phẩm (thêm/sửa/xóa)");
            System.out.println("4. Quản lý đơn hàng");
            System.out.println("5. Quản lý tài khoản khách hàng");
            System.out.println("6. Quản lý khuyến mãi");
            System.out.println("7. Xem báo cáo doanh thu");
            System.out.println("8. Xem danh sách sản phẩm");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            chon = nhapSo();

            switch (chon) {
                case 1:
                    System.out.print("Mật khẩu mới: ");
                    String mkMoi = sc.nextLine();
                    if (Account.hopLe(ql.getTenDangNhap(), mkMoi)) {
                        ql.setMatKhau(mkMoi);
                        CustomerManager.capNhatTuMap(danhSachTK);
                        System.out.println("Đã cập nhật mật khẩu.");
                    } else {
                        System.out.println("Mật khẩu không hợp lệ theo quy tắc.");
                    }
                    break;
                case 2:
                    System.out.print("Tên tài khoản cần đổi: ");
                    String ten = sc.nextLine();
                    Account tk = danhSachTK.get(ten);
                    if (tk != null) {
                        System.out.print("Mật khẩu mới: ");
                        String newPass = sc.nextLine();
                        if (Account.hopLe(ten, newPass)) {
                            tk.setMatKhau(newPass);
                            CustomerManager.capNhatTuMap(danhSachTK);
                            System.out.println("Đổi mật khẩu thành công cho tài khoản: " + ten);
                        } else {
                            System.out.println("Mật khẩu không hợp lệ theo quy tắc.");
                        }
                    } else {
                        System.out.println("Không tìm thấy tài khoản.");
                    }
                    break;
                case 3:
                    System.out.println("1. Thêm | 2. Sửa | 3. Xóa");
                    int c = nhapSo();
                    List<Product> spList = ProductManager.getDanhSachSP();
                    if (c == 1) {
                        System.out.print("Mã: "); String ma = sc.nextLine();
                        System.out.print("Tên: "); String tenSp = sc.nextLine();
                        System.out.print("Giá: "); double gia = Double.parseDouble(sc.nextLine());
                        System.out.print("Mô tả: "); String mota = sc.nextLine();
                        spList.add(new Product(ma, tenSp, gia, mota));
                        ProductManager.luuFile();
                        System.out.println("Đã thêm sản phẩm.");
                    } else if (c == 2) {
                        System.out.print("Mã cần sửa: "); String ma = sc.nextLine();
                        for (Product sp : spList) {
                            if (sp.getMaSP().equals(ma)) {
                                System.out.print("Tên mới: "); sp.setTenSP(sc.nextLine());
                                System.out.print("Giá mới: "); sp.setGia(Double.parseDouble(sc.nextLine()));
                                System.out.print("Mô tả mới: "); sp.setMoTa(sc.nextLine());
                            }
                        }
                        ProductManager.luuFile();
                        System.out.println("Đã cập nhật sản phẩm.");
                    } else if (c == 3) {
                        System.out.print("Mã cần xóa: "); String ma = sc.nextLine();
                        spList.removeIf(sp -> sp.getMaSP().equals(ma));
                        ProductManager.luuFile();
                        System.out.println("Đã xóa sản phẩm.");
                    }
                    break;
                case 4:
                    try (Scanner reader = new Scanner(new File("hoadon.txt"))) {
                        System.out.println("--- DANH SÁCH ĐƠN HÀNG ---");
                        while (reader.hasNextLine()) {
                            System.out.println(reader.nextLine());
                        }
                    } catch (Exception e) {
                        System.out.println("Không có đơn hàng nào.");
                    }
                    break;
                case 5:
                    System.out.println("--- DANH SÁCH TÀI KHOẢN KHÁCH HÀNG ---");
                    for (Account acc : danhSachTK.values()) {
                        if ("KhachHang".equals(acc.getVaiTro())) {
                            System.out.println("- " + acc.getTenDangNhap());
                        }
                    }
                    break;
                case 6:
                    System.out.print("Nhập % giảm giá: ");
                    double percent = Double.parseDouble(sc.nextLine());
                    for (Product sp : ProductManager.getDanhSachSP()) {
                        double newPrice = sp.getGia() * (1 - percent / 100);
                        sp.setGia(newPrice);
                    }
                    ProductManager.luuFile();
                    System.out.println("Đã cập nhật giá theo khuyến mãi.");
                    break;
                case 7:
                    double total = 0;
                    try (Scanner reader = new Scanner(new File("hoadon.txt"))) {
                        while (reader.hasNextLine()) {
                            String line = reader.nextLine();
                            if (line.startsWith("Tổng tiền:")) {
                                String[] parts = line.split(":");
                                total += Double.parseDouble(parts[1].trim().replace(" VNĐ", ""));
                            }
                        }
                        System.out.println("Tổng doanh thu: " + total + " VNĐ");
                    } catch (Exception e) {
                        System.out.println("Không có dữ liệu doanh thu.");
                    }
                    break;
                case 8:
                    System.out.println("--- DANH SÁCH SẢN PHẨM ---");
                    for (Product sp : ProductManager.getDanhSachSP()) {
                        System.out.println(sp);
                    }
                    break;
            }
        } while (chon != 0);
    }
    static void menuNhanVienKho(Account nvk) {
        int chon;
        do {
            System.out.println("\n--- MENU NHÂN VIÊN KHO ---");
            System.out.println("1. Xem danh sách sản phẩm");
            System.out.println("2. Kiểm tra tồn kho theo mã sản phẩm");
            System.out.println("3. Cập nhật mô tả sản phẩm");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            chon = nhapSo();

            switch (chon) {
                case 1:
                    for (Product sp : ProductManager.getDanhSachSP()) {
                        System.out.println(sp);
                    }
                    break;
                case 2:
                    System.out.print("Nhập mã sản phẩm: ");
                    String ma = sc.nextLine();
                    boolean found = false;
                    for (Product sp : ProductManager.getDanhSachSP()) {
                        if (sp.getMaSP().equalsIgnoreCase(ma)) {
                            System.out.println("Tồn kho: " + sp);
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("Không tìm thấy sản phẩm.");
                    break;
                case 3:
                    System.out.print("Nhập mã sản phẩm cần cập nhật mô tả: ");
                    String maSp = sc.nextLine();
                    for (Product sp : ProductManager.getDanhSachSP()) {
                        if (sp.getMaSP().equalsIgnoreCase(maSp)) {
                            System.out.print("Mô tả mới: ");
                            sp.setMoTa(sc.nextLine());
                            ProductManager.luuFile();
                            System.out.println("Đã cập nhật mô tả.");
                            break;
                        }
                    }
                    break;
            }
        } while (chon != 0);
    }
    static void menuNhanVienBanHang(Account nvbh) {
        ShoppingCart gio = new ShoppingCart();
        int chon;
        do {
            System.out.println("\n--- MENU NHÂN VIÊN BÁN HÀNG ---");
            System.out.println("1. Xem danh sách sản phẩm");
            System.out.println("2. Thêm sản phẩm vào giỏ cho khách");
            System.out.println("3. In hóa đơn thanh toán");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            chon = nhapSo();

            switch (chon) {
                case 1:
                    for (Product sp : ProductManager.getDanhSachSP()) {
                        System.out.println(sp);
                    }
                    break;
                case 2:
                    System.out.print("Nhập mã sản phẩm: ");
                    String ma = sc.nextLine();
                    for (Product sp : ProductManager.getDanhSachSP()) {
                        if (sp.getMaSP().equalsIgnoreCase(ma)) {
                            gio.them(sp);
                            System.out.println("Đã thêm vào giỏ.");
                            break;
                        }
                    }
                    break;
                case 3:
                    boolean ok = Payment.xuLyThanhToan();
                    Invoice.inHoaDon(gio, nvbh.getSoTaiKhoan(), "SHOP123456", ok);
                    gio = new ShoppingCart(); // reset giỏ hàng
                    break;
            }
        } while (chon != 0);
    }
}
