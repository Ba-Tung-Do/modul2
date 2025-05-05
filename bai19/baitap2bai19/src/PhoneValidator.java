import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidator {
    private static final String PHONE_REGEX = "^\\(\\d{2}\\)-\\(0\\d{9}\\)$";
    private static final Pattern pattern = Pattern.compile(PHONE_REGEX);

    public static boolean isValidPhone(String phone) {
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Nhập số điện thoại: ");
            String input = scanner.nextLine();

            if (isValidPhone(input)) {
                System.out.println("Số điện thoại hợp lệ.");
            } else {
                System.out.println("Số điện thoại không hợp lệ.");
            }
        } catch (Exception e) {
            System.out.println("Lỗi nhập liệu: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
