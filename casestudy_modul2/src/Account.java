import java.util.regex.*;

public class Account {
    private String tenDangNhap, matKhau, vaiTro, soTaiKhoan;

    public Account(String tenDangNhap, String matKhau, String vaiTro, String soTaiKhoan) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
        this.soTaiKhoan = soTaiKhoan;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }
    public String getMatKhau() {
        return matKhau;
    }
    public String getVaiTro() {
        return vaiTro;
    }
    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public boolean kiemTraDangNhap(String ten, String mk) {
        return ten.equals(this.tenDangNhap) && mk.equals(this.matKhau);
    }

    public static boolean hopLe(String ten, String mk) {
        String regexTen = "^[a-zA-Z0-9_]{4,20}$";
        String regexMK = "^[A-Z][a-zA-Z0-9]{5,}$";
        return ten.matches(regexTen) && mk.matches(regexMK);
    }
}
