public class NhanVienPartTime extends NhanVien {
    private double soGio;
    NhanVienPartTime(String id, String name, int age, String email, String phone,double soGio ) {
        super(id, name, age, email, phone);
        this.soGio = soGio;


    }

    public double getSoGio() {
        return soGio;
    }

    public void setSoGio(double soGio) {
        this.soGio = soGio;
    }
    public double tinhLuong() {
        return soGio * 100000;
    }
    @Override
    public String toString() {
        return super.toString() + ",soGio=" + soGio;
    }
}

