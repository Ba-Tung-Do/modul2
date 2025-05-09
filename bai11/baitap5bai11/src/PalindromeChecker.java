import java.util.*;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String input = sc.nextLine();

        if (isPalindrome(input)) {
            System.out.println("Đây là chuỗi Palindrome.");
        } else {
            System.out.println(" Đây KHÔNG phải là chuỗi Palindrome.");
        }
    }

    public static boolean isPalindrome(String s) {
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // Làm sạch chuỗi: loại bỏ khoảng trắng, chuyển về chữ thường
        String clean = s.replaceAll("[^a-zA-Z]", "").toLowerCase();

        for (char ch : clean.toCharArray()) {
            queue.add(ch);   // đọc xuôi
            stack.push(ch);  // đọc ngược
        }

        while (!queue.isEmpty()) {
            if (queue.poll() != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}
