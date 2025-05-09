public class NhanVien  {
    String hoTen;
    String gioiTinh;
    String ngaySinh;

    public NhanVien(String hoTen, String gioiTinh, String ngaySinh) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh.toLowerCase();
        this.ngaySinh = ngaySinh;
    }

    @Override
    public String toString() {
        return hoTen + " - " + gioiTinh + " - " + ngaySinh;
    }
}

