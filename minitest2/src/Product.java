class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;

    private static String storeName = "Kho Tổng ABC";
    private static int totalProduct = 0;
    private static double totalInventoryValue = 0;

    // Constructor
    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;

        totalProduct++;
        totalInventoryValue += getInventoryValue();
    }

    // Hiển thị thông tin sản phẩm
    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Tên: " + name);
        System.out.println("Giá: " + price);
        System.out.println("Số lượng: " + quantity);
        System.out.println("Giá trị tồn kho: " + getInventoryValue());
        System.out.println("Tên kho: " + storeName);
        System.out.println("-------------------------");
    }

    public double getInventoryValue() {
        return price * quantity;
    }

    public static double getAveragePrice() {
        return totalProduct == 0 ? 0 : totalInventoryValue / totalProduct;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public static int getTotalProduct() {
        return totalProduct;
    }

    public static double getTotalInventoryValue() {
        return totalInventoryValue;
    }

    public static String getStoreName() {
        return storeName;
    }

    public static void setStoreName(String name) {
        storeName = name;
    }
}
