import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Map<String, Account> danhSachTK = new HashMap<>();
    static List<Product> sanPhamList = new ArrayList<>();

    public static void main(String[] args) {
        danhSachTK.put("Admin01", new Account("Admin01", "A123456", "QuanLy", "999111"));
        danhSachTK.put("Admin02", new Account("Admin02", "A123456", "Kho", "999222"));
        danhSachTK.put("Admin03", new Account("Admin03", "A123456", "BanHang", "999333"));

        sanPhamList.add(new Product("SP01", "Áo thun", 250000, "Cotton 100%"));
        sanPhamList.add(new Product("SP02", "Quần jeans", 400000, "Denim bền chắc"));

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
        danhSachTK.put(ten, new Account(ten, mk, "KhachHang", stk));
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
                    for (Product sp : sanPhamList) System.out.println(sp);
                    break;
                case 2:
                    System.out.print("Từ khóa: ");
                    String kw = sc.nextLine();
                    for (Product sp : sanPhamList)
                        if (sp.getTenSP().toLowerCase().contains(kw.toLowerCase()))
                            System.out.println(sp);
                    break;
                case 3:
                    System.out.print("Nhập mã sản phẩm: ");
                    String ma = sc.nextLine();
                    boolean found = false;
                    for (Product sp : sanPhamList) {
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
            System.out.println("\n--- MENU QUẢN LÝ CỬA HÀNG ---");
            System.out.println("1. Đổi mật khẩu của chính mình");
            System.out.println("2. Đổi mật khẩu tài khoản bất kỳ");
            System.out.println("3. Xem sản phẩm");
            System.out.println("4. Quản lý sản phẩm (thêm/sửa/xóa)");
            System.out.println("5. Quản lý tài khoản khách hàng");
            System.out.println("6. Quản lý khuyến mãi");
            System.out.println("7. Xem báo cáo doanh thu");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            chon = nhapSo();

            switch (chon) {
                case 1:
                    System.out.print("Mật khẩu mới: ");
                    String mkMoi = sc.nextLine();
                    ql.setMatKhau(mkMoi);
                    System.out.println("Đã cập nhật mật khẩu của bạn.");
                    break;
                case 2:
                    System.out.print("Tên tài khoản cần đổi: ");
                    String ten = sc.nextLine();
                    Account tk = danhSachTK.get(ten);
                    if (tk != null) {
                        System.out.print("Mật khẩu mới: ");
                        String newPass = sc.nextLine();
                        tk.setMatKhau(newPass);
                        System.out.println("Đổi mật khẩu thành công cho tài khoản: " + ten);
                    } else {
                        System.out.println("Không tồn tại tài khoản.");
                    }
                    break;
                case 3:
                    for (Product sp : sanPhamList) System.out.println(sp);
                    break;
                case 4:
                    System.out.println("1. Thêm | 2. Sửa | 3. Xóa");
                    int c = nhapSo();
                    if (c == 1) {
                        System.out.print("Mã: "); String ma = sc.nextLine();
                        System.out.print("Tên: "); String tenSp = sc.nextLine();
                        System.out.print("Giá: "); double gia = Double.parseDouble(sc.nextLine());
                        System.out.print("Mô tả: "); String mota = sc.nextLine();
                        sanPhamList.add(new Product(ma, tenSp, gia, mota));
                    } else if (c == 2) {
                        System.out.print("Mã cần sửa: "); String ma = sc.nextLine();
                        for (Product sp : sanPhamList) {
                            if (sp.getMaSP().equals(ma)) {
                                System.out.print("Tên mới: "); sp.setTenSP(sc.nextLine());
                                System.out.print("Giá mới: "); sp.setGia(Double.parseDouble(sc.nextLine()));
                                System.out.print("Mô tả mới: "); sp.setMoTa(sc.nextLine());
                            }
                        }
                    } else if (c == 3) {
                        System.out.print("Mã cần xóa: "); String ma = sc.nextLine();
                        sanPhamList.removeIf(sp -> sp.getMaSP().equals(ma));
                    }
                    break;
                case 5:
                    System.out.println("Danh sách tài khoản khách hàng:");
                    for (Account acc : danhSachTK.values())
                        if (acc.getVaiTro().equals("KhachHang"))
                            System.out.println("- " + acc.getTenDangNhap());
                    break;
                case 6:
                    System.out.println("(Chức năng khuyến mãi đang giả lập)");
                    break;
                case 7:
                    System.out.println("(Chức năng báo cáo doanh thu đang giả lập)");
                    break;
            }
        } while (chon != 0);
    }

    static void menuNhanVienKho(Account nvk) {
        System.out.println("\n--- MENU NHÂN VIÊN KHO ---");
        System.out.println("(1) Cập nhật tồn kho: nhập/xuất ");
        System.out.println("(2) Theo dõi giao hàng ");
        System.out.println("(0) Thoát");
        int chon = nhapSo();
        if (chon == 1) System.out.println("Cập nhật tồn kho thành công.");
        else if (chon == 2) System.out.println("Đơn hàng đang trên đường giao.");
    }

    static void menuNhanVienBanHang(Account nvbh) {
        System.out.println("\n--- MENU NHÂN VIÊN BÁN HÀNG ---");
        System.out.println("1. Xem sản phẩm");
        System.out.println("2. Tìm sản phẩm");
        System.out.println("3. In hóa đơn ");
        System.out.println("4. Theo dõi đơn hàng (giả lập)");
        System.out.println("0. Thoát");
        int chon = nhapSo();
        if (chon == 1) for (Product sp : sanPhamList) System.out.println(sp);
        else if (chon == 2) {
            System.out.print("Nhập từ khóa: ");
            String kw = sc.nextLine();
            for (Product sp : sanPhamList)
                if (sp.getTenSP().toLowerCase().contains(kw.toLowerCase()))
                    System.out.println(sp);
        }
        else if (chon == 3) System.out.println("Đã in hóa đơn .");
        else if (chon == 4) System.out.println("Đơn hàng đang xử lý...");
    }
}
