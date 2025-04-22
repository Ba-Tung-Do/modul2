public class Car extends Vehicle {
    public int numberOfSeats;

    public Car(String id, String brand, int year, int numberOfSeats) {
        super(id, brand, year);
        this.numberOfSeats = numberOfSeats;
    }
    public void displayInfo() {
        System.out.println("xe o to" + id + "thuong hieu "+ brand + "Nam san xuat : " + year);
    }
}
