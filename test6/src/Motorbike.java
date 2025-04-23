public class Motorbike extends Vehicle {
    public int enginePower;

    public Motorbike(String id, String brand, int year, int enginePower) {
        super(id, brand, year);
        this.enginePower = enginePower;
    }
    @Override
    public void displayInfo() {
    }
    @Override
    public double calculateTax() {
        if (enginePower < 100) {
            return  500;
        } return 1000;
    }
}
