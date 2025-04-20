import java.util.Comparator;

public class TaxComparator implements Comparator<Vehicle> {
    @Override
    public int compare(Vehicle v1, Vehicle v2) {
        return Double.compare(v1.calculateTax(), v2.calculateTax());
    }
}