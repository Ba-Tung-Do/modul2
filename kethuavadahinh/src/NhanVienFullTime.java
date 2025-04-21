public class NhanVienFullTime extends NhanVien {
    private double tienThuong;
    private double luongCung;
    private double tienPhat;

    NhanVienFullTime(String id, String name, int age, String email, String phone, double tienThuong, double luongCung, double tienPhat) {
        super(id, name, age, email, phone);
        this.tienThuong = tienThuong;
        this.luongCung = luongCung;
        this.tienPhat = tienPhat;
    }

    public double getTienThuong() {
        return tienThuong;
    }

    public void setTienThuong(double tienThuong) {
        this.tienThuong = tienThuong;
    }

    public double getLuongCung() {
        return luongCung;
    }

    public void setLuongCung(double luongCung) {
        this.luongCung = luongCung;
    }

    public double getTienPhat() {
        return tienPhat;
    }

    public void setTienPhat(double tienPhat) {
        this.tienPhat = tienPhat;
    }
    public double getLuongThuong() {
        return luongCung + tienThuong - tienPhat;
    }
    @Override
    public String toString() {
        return super.toString() +
                ",tienThuong=" + tienThuong + ",luongCung=" + luongCung + ",tienPhat=" + tienPhat;
    }
}

