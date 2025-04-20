public class Motorbike extends  Vehicle {
    private int enginePower;

    public Motorbike(String id, String brand, int year, int enginePower) {
        super(id, brand, year);
        this.enginePower = enginePower;
    }
    @Override
    public double calculateTax() {
        return enginePower < 100 ? 500 : 1000;
    }
    @Override
    public void displayInfo() {
        System.out.println("Motorbike:  " + id  + " , Thuong hieu : " +  getBrand() + ", Nam san xuat :" + getYear() + ", Cong suat dong co (HP) :" + enginePower);
    }
}
