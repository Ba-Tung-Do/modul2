public class PersonnelFullTime extends Personnel {
    private double tienThuong;
    private double tienPhat;
    private double luongCung;

    public PersonnelFullTime(String id, String name, int age, String number, String email,
                             double tienThuong, double tienPhat, double luongCung) {
        super(id, name, age, number, email);
        this.tienThuong = tienThuong;
        this.tienPhat = tienPhat;
        this.luongCung = luongCung;
    }

    @Override
    public double tinhLuong() {
        return luongCung + (tienThuong - tienPhat);
    }

    public double getLuong() {
        return tinhLuong();
    }
}
