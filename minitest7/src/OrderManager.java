import java.util.*;
import java.io.*;

public class OrderManager {
    private ArrayList<Order> orders = new ArrayList<>();
    private LinkedList<String> history = new LinkedList<>();

    public void addOrder(Order o) {
        orders.add(o);
        history.add("Added order: " + o.getOrderId());
    }

    public void removeOrder(String orderId) {
        boolean removed = orders.removeIf(order -> order.getOrderId().equals(orderId));
        if (removed) {
            history.add("Removed order: " + orderId);
        }
    }

    public void displayAllOrders() {
        for (Order o : orders) {
            o.displayInfo();
        }
    }

    public void displayRevenueReport() {
        for (Order o : orders) {
            System.out.println(o.getOrderId() + ": " + o.calculateTotalPrice());
        }
    }

    public void sortByOrderDate() {
        Collections.sort(orders);
        history.add("Sorted orders by OrderDate");
    }

    public void sortByCustomerName() {
        orders.sort(new CustomerNameComparator());
        history.add("Sorted orders by CustomerName");
    }

    public void sortByTotalPrice() {
        orders.sort(new TotalPriceComparator());
        history.add("Sorted orders by TotalPrice");
    }

    public void printHistory() {
        for (String h : history) {
            System.out.println(h);
        }
    }

    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(orders);
            history.add("Saved orders to file: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            orders = (ArrayList<Order>) ois.readObject();
            history.add("Loaded orders from file: " + filename);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
