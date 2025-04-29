import java.io.*;

public class CopyFileText {
    public static void main(String[] args) {
        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            // 1. Nhập đường dẫn file
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Nhập đường dẫn file nguồn: ");
            String sourcePath = consoleReader.readLine();
            System.out.print("Nhập đường dẫn file đích: ");
            String targetPath = consoleReader.readLine();

            File sourceFile = new File(sourcePath);
            File targetFile = new File(targetPath);

            // 2. Kiểm tra file nguồn
            if (!sourceFile.exists()) {
                System.out.println(" File nguồn không tồn tại.");
                return;
            }

            // 3. Kiểm tra file đích
            if (targetFile.exists()) {
                System.out.println(" File đích đã tồn tại. Không cho ghi đè.");
                return;
            }

            // 4. Tạo luồng đọc và ghi
            reader = new BufferedReader(new FileReader(sourceFile));
            writer = new BufferedWriter(new FileWriter(targetFile));

            int characterCount = 0; // Đếm ký tự

            int c;
            while ((c = reader.read()) != -1) {
                writer.write(c);
                characterCount++;
            }

            System.out.println("Sao chép thành công! Số ký tự đã sao chép: " + characterCount);

        } catch (IOException e) {
            System.err.println(" Lỗi xử lý file: " + e.getMessage());
        } finally {
            try {
                if (reader != null) reader.close();
                if (writer != null) writer.close();
            } catch (IOException e) {
                System.err.println(" Lỗi đóng file: " + e.getMessage());
            }
        }
    }
}
