import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private final String FILE_NAME = "products.dat";

    public void addProduct(Product product) {
        List<Product> products = getAllProducts();
        products.add(product);
        saveAllProducts(products);
    }

    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            list = (List<Product>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // File chưa tồn tại hoặc rỗng thì trả list rỗng
        }
        return list;
    }

    public void saveAllProducts(List<Product> products) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(products);
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }

    public Product searchById(String id) {
        List<Product> products = getAllProducts();
        for (Product p : products) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }
}
