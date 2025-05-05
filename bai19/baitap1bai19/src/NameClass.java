import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameClass {
    private static final String NAMECLASS_REGEX = "^[CAP]\\d{4}]{6,}$";
    private static final Pattern pattern = Pattern.compile(NAMECLASS_REGEX);

    public static boolean isValidClassName(String regex) {
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập tên lớp cần kiểm tra: ");
            String input = scanner.nextLine();

            if (isValidClassName(input)) {
                System.out.println("Tên lớp hợp lệ.");
            } else {
                System.out.println("Tên lớp không hợp lệ.");
            }
        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
