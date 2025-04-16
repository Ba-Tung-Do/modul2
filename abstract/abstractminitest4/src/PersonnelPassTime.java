public class PersonnelPassTime extends Personnel {
   private int soGioLamViec;

   public PersonnelPassTime(String id, String name, int age, String number, String emaill, int soGioLamViec) {
       super(id, name, age, number, emaill);
       this.soGioLamViec = soGioLamViec;
   }
   @Override
    public double tinhLuong(){
       return soGioLamViec * 100000;
   }
   public int getSoGioLamViec() {
       return soGioLamViec;
   }
   @Override
    public String toString() {
       return super.toString() + "PASSTIME: " + soGioLamViec + tinhLuong();
   }
}
