//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Scanner;
//
//public class SortCharactersWithArrayList {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        // Nhập chuỗi từ người dùng
//        System.out.print("Nhập chuỗi bất kỳ: ");
//        String input = scanner.nextLine();
//
//        // Tạo danh sách ký tự từ chuỗi
//        ArrayList<Character> charList = new ArrayList<>();
//
//        for (char c : input.toCharArray()) {
//            charList.add(c);
//        }
//
//        // Sắp xếp danh sách ký tự
//        Collections.sort(charList);
//
//        // Tạo chuỗi kết quả từ ArrayList đã sắp xếp
//        StringBuilder sortedString = new StringBuilder();
//        for (char c : charList) {
//            sortedString.append(c);
//        }
//
//        // In kết quả
//        System.out.println("Chuỗi sau khi sắp xếp: " + sortedString);
//    }
//}
import java.util.*;

public class ProductManager {
    private ArrayList<Product> productsList = new ArrayList<>();

    public void addProduct(Product product) {
        productsList.add(product);
    }
    public void editProduct(int id,String newName,double newPrice){
        for (int i = 0; i < productsList.size(); i++) {
            Product p = productsList.get(i);
            if (p.getId() == id) {
                p.setName(newName);
                p.setPrice(newPrice);
                return;
            }
        }
        System.out.println("Khong tim thay san pham voi id la :"+ id);
    }
    public void deleteProduct(int id){
        for (Product product : productsList) {
            Product productToDelete = productsList.get(id);
            if (productToDelete.equals(product)) {
                productsList.remove(product);
                return;
            }
        }
    }

    public void displayAllProducts(){
        for (Product product : productsList) {
            System.out.println(productsList);
        }
    }
    public LinkedList<Product> searchProduct(String keyword) {
        LinkedList<Product> result = new LinkedList<>(); // khoi tao 1 danh sach rong
        for (int i = 0; i < productsList.size(); i++) { // duyet danh sach san pham tu
           Product product = productsList.get(i); // lay san pham thu i gan vao bien product
           if (product.getName().toLowerCase().contains(keyword.toLowerCase())) { // kiem tra xem ten san pham co chua tu khoa keywork
               result.add(product); // neu co them vao danh sach result
           }
        }
        return result;
    }
    public void sortByPriceAscending() {
        Collections.sort(productsList,new Comparator<Product>() {
            public int compare(Product p1,Product p2){
                return Double.compare(p1.getPrice(), p2.getPrice());
            }
        });
    }
    public void sortByPriceDescending() {
        Collections.sort(productsList,new Comparator<Product>() {
            public int compare(Product p1,Product p2){
                return Double.compare(p1.getPrice(),p2.getPrice());
            }
        });
    }
}