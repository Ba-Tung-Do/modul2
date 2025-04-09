import java.util.Scanner;

public class DocSoThanhChu {

    // Mảng các số từ 0-9 và các đơn vị lớn hơn
    static String[] donVi = {"", "một", "hai", "ba", "bốn", "năm", "sáu", "bảy", "tám", "chín"};
    static String[] chuc = {"", "mười", "hai mươi", "ba mươi", "bốn mươi", "năm mươi", "sáu mươi", "bảy mươi", "tám mươi", "chín mươi"};
    static String[] tram = {"", "một trăm", "hai trăm", "ba trăm", "bốn trăm", "năm trăm", "sáu trăm", "bảy trăm", "tám trăm", "chín trăm"};

    // Hàm chuyển đổi số thành chữ
    public static String docSo(int so) {
        if (so == 0) {
            return "Không";
        }

        String result = "";

        // Xử lý chữ trăm
        if (so >= 100) {
            int tr = so / 100;  // lấy chữ trăm
            result += tram[tr];
            so = so % 100;
        }

        // Xử lý chữ chục
        if (so >= 20) {
            int ch = so / 10;  // lấy chữ chục
            result += " " + chuc[ch];
            so = so % 10;
        } else if (so >= 10) {
            // Trường hợp từ 10 đến 19
            result += " mười";
            so = so % 10;
        }

        // Xử lý chữ đơn vị
        if (so > 0) {
            if (so == 1 && result.contains("mười")) {
                result += " một";
            } else {
                result += " " + donVi[so];
            }
        }

        return result.trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập một số từ 0 đến 999: ");
        int so = sc.nextInt();

        // Kiểm tra giới hạn của số
        if (so < 0 || so > 999) {
            System.out.println("Số nhập vào không hợp lệ!");
        } else {
            String ketQua = docSo(so);
            System.out.println("Số " + so + " đọc thành: " + ketQua);
        }

        sc.close();
    }
}
