import java.time.LocalDate;

public class CrispyFlour extends Material {
    private int quantity;

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, int quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    @Override
    public double getAmount() {
        return getCost() * quantity;
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufacturingDate().plusYears(1);
    }

    @Override
    public double getRealMoney() {
        long daysLeft = getExpiryDate().toEpochDay() - LocalDate.now().toEpochDay();
        double amount = getAmount();

        if (daysLeft <= 60) return amount * 0.6;
        else if (daysLeft <= 120) return amount * 0.8;
        else return amount * 0.95;
    }
}
