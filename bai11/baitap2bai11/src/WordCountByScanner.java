import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordCountByScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap vao mot doan van ban:");
        String text = scanner.nextLine(); // Người dùng nhập văn bản

        // Dùng TreeMap để tự động sắp xếp từ theo bảng chữ cái
        Map<String, Integer> wordCount = new TreeMap<>();

        // Dùng Scanner để đọc từng từ trong text
        Scanner wordScanner = new Scanner(text);
        while (wordScanner.hasNext()) {
            String word = wordScanner.next();
            word = word.toLowerCase(); // Không phân biệt chữ hoa thường
            word = word.replaceAll("[^a-zA-Z0-9]", ""); // Bỏ dấu câu như .,!? nếu có

            if (word.isEmpty()) continue; // Nếu từ rỗng thì bỏ qua

            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }

        System.out.println("\nKet qua dem tu:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
        wordScanner.close();
    }
}
