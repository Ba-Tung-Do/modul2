import java.io.*;
import java.util.Scanner;

public class CopyFileBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập đường dẫn file nguồn: ");
        String sourcePath = scanner.nextLine();

        System.out.print("Nhập đường dẫn file đích: ");
        String targetPath = scanner.nextLine();

        File sourceFile = new File(sourcePath);
        File targetFile = new File(targetPath);

        // Kiểm tra file nguồn tồn tại
        if (!sourceFile.exists()) {
            System.out.println("File nguồn không tồn tại.");
            return;
        }

        // Kiểm tra file đích đã tồn tại
        if (targetFile.exists()) {
            System.out.println("File đích đã tồn tại. Vui lòng chọn tên khác hoặc xóa file đích.");
            return;
        }

        // Tiến hành sao chép
        try (
                FileInputStream fis = new FileInputStream(sourceFile);
                FileOutputStream fos = new FileOutputStream(targetFile);
        ) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            int totalBytes = 0;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
                totalBytes += bytesRead;
            }

            System.out.println("Sao chép thành công. Tổng số byte đã sao chép: " + totalBytes);

        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        }
    }
}
