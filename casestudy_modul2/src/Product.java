public class Product {
    private String maSP, tenSP, moTa;
    private double gia;

    public Product(String maSP, String tenSP, double gia, String moTa) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.gia = gia;
        this.moTa = moTa;
    }

    public String getMaSP() { return maSP; }
    public String getTenSP() { return tenSP; }
    public double getGia() { return gia; }
    public String getMoTa() { return moTa; }

    public void setTenSP(String tenSP) { this.tenSP = tenSP; }
    public void setGia(double gia) { this.gia = gia; }
    public void setMoTa(String moTa) { this.moTa = moTa; }

    @Override
    public String toString() {
        return maSP + " - " + tenSP + ": " + gia + " VNĐ | " + moTa;
    }
}
