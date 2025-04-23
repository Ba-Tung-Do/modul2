import java.util.Comparator; // khai bao thu vien sap xep

public class TaxComparator implements Comparator<Vehicle> {
    @Override
    public int compare(Vehicle v1, Vehicle v2) {
        return Double.compare(v1.calculateTax(), v2.calculateTax());
    }
}