import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class VehicleManager {
    private List<Vehicle> vehicles = new ArrayList<>();
    private List<String> history = new LinkedList<>();

    public void addVehicle(Vehicle v) {
        vehicles.add(v);
        history.add("Them: " + v.getId());
    }

    public boolean removeVehicle(String id) {
        for (Vehicle v : vehicles) {
            if (v.getId().equals(id)) {
                vehicles.remove(v);
                history.add("Xoa: " + id);
                return true;
            }
        }
        return false;
    }

    public void displayAllVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("Danh sach rong.");
        } else {
            for (Vehicle v : vehicles) {
                v.displayInfo();
            }
        }
    }

    public void displayTaxReport() {
        for (Vehicle v : vehicles) {
            System.out.println("ID: " + v.getId() + ", Thue: " + v.calculateTax());
        }
    }

    public void sortByYear() {
        vehicles.sort(null);
        System.out.println("Sap xep theo nam san xuat thanh cong.");
    }

    public void sortByBrand() {
        vehicles.sort(new BrandComparator());
        System.out.println("Sap xep theo hang san xuat thanh cong.");
    }

    public void sortByTax() {
        vehicles.sort(new TaxComparator());
        System.out.println("Sap xep theo thue tang dan thanh cong.");
    }

    public void printHistory() {
        if (history.isEmpty()) {
            System.out.println("Chua co thao tac nao.");
        } else {
            for (String record : history) {
                System.out.println(record);
            }
        }
    }
    public void displayTaxiById(String id){
        for (Vehicle v : vehicles) {
            if (v.getId().equals(id)) {
                System.out.println("ID: " + v.getId() + ", Thue: " + v.calculateTax());
                return;
            }
        }
        System.out.println("Khong tim thay phuong tien voi ID : " + id + " vua nhap , moi nhap lai ");
    }
}
