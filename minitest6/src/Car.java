public class Car extends Vehicle {
    private int numberOfSeats;

    public Car(String id, String brand, int year, int numberOfSeats) {
        super(id, brand, year);
        this.numberOfSeats = numberOfSeats;
    }
    @Override
    public double calculateTax(){
        return numberOfSeats * 300;
    }
    @Override
    public void displayInfo() {
        System.out.println("Car : " + id + ", Thuong hieu : "+ brand + "Nam san xuat :" + year + ", So ghe :"+ numberOfSeats) ;
    }
}
