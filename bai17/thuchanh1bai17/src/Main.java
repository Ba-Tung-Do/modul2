import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class Main {

    private static void copyFileUsingJava7Files(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            if (is != null) is.close();
            if (os != null) os.close();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter source file: ");
        String sourcePath = in.nextLine();
        System.out.print("Enter destination file: ");
        String destPath = in.nextLine();

        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);

        try {
            // Dùng một trong hai cách dưới đây:
            copyFileUsingJava7Files(sourceFile, destFile); // Cách dùng NIO
            // copyFileUsingStream(sourceFile, destFile); // Cách dùng Stream

            System.out.println("Copy completed!");
        } catch (IOException ioe) {
            System.out.println("Can't copy that file.");
            System.out.println(ioe.getMessage());
        }
    }
}
