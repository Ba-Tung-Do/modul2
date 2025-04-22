public class Motobike extends Vehicle {
    public int enginePower;

    public Motobike(String id, String brand, int year, int enginePower) {
        super(id, brand, year);
        this.enginePower = enginePower;
    }
    @Override
    public void displayInfo() {

        return "motorbike"+ id + "Thuong hieu :" + brand + "Nam san xuat : " + year;
    }
}
