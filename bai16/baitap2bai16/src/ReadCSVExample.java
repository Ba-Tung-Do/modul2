import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSVExample {
    public static void main(String[] args) {
        String csvFile = "C:\\Users\\Gigabyte\\IdeaProjects\\codegym\\bai16\\baitap2bai16\\contries1.txt"; // Đường dẫn file CSV
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            System.out.println("Danh sách quốc gia:");

            while ((line = br.readLine()) != null) {
                String[] data = line.split(","); // Tách dữ liệu theo dấu phẩy

                // Lấy và làm sạch dữ liệu
                int id = Integer.parseInt(data[0]);
                String code = data[1].replace("\"", "");     // Xóa dấu ngoặc kép
                String name = data[2].replace("\"", "");

                // Hiển thị
                System.out.println("ID: " + id + ", Code: " + code + ", Name: " + name);
            }

        } catch (IOException e) {
            System.err.println(" Lỗi khi đọc file: " + e.getMessage());
        }
    }
}
