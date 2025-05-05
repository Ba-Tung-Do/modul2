import java.io.*;
import java.util.Scanner;

public class AccountManager {
    private static final String FILE_NAME = "accounts.txt";
    private Scanner scanner = new Scanner(System.in);
    private AccountExample validator = new AccountExample();

    public void register() {
        System.out.print("Nhập tên tài khoản: ");
        String username = scanner.nextLine();

        if (!validator.validate(username)) {
            System.out.println("Tên tài khoản không hợp lệ.");
            return;
        }

        if (accountExists(username)) {
            System.out.println("Tài khoản đã tồn tại!");
            return;
        }

        System.out.print("Nhập mật khẩu: ");
        String password = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(username + ":" + password);
            writer.newLine();
            System.out.println("Đăng ký thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    public void login() {
        System.out.print("Nhập tên tài khoản: ");
        String username = scanner.nextLine();
        System.out.print("Nhập mật khẩu: ");
        String password = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                    found = true;
                    break;
                }
            }
            if (found) {
                System.out.println("Đăng nhập thành công!");
            } else {
                System.out.println("Tài khoản hoặc mật khẩu không đúng.");
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }

    private boolean accountExists(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length > 0 && parts[0].equals(username)) {
                    return true;
                }
            }
        } catch (IOException e) {
            // File chưa tồn tại hoặc lỗi đọc
        }
        return false;
    }
}
