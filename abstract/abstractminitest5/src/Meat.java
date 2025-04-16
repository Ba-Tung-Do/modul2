import java.time.LocalDate;

public class Meat extends Material {
    private double weight;

    public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
    }

    @Override
    public double getAmount() {
        return getCost() * weight;
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufacturingDate().plusDays(7);
    }

    @Override
    public double getRealMoney() {
        long daysLeft = getExpiryDate().toEpochDay() - LocalDate.now().toEpochDay();
        double amount = getAmount();

        if (daysLeft <= 5) return amount * 0.7;
        else return amount * 0.9;
    }
}
