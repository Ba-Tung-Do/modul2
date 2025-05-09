import java.util.*;

public class BracketChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập biểu thức: ");
        String expression = scanner.nextLine();

        if (isBalanced(expression)) {
            System.out.println(" Biểu thức có dấu ngoặc hợp lệ.");
        } else {
            System.out.println("Biểu thức có dấu ngoặc KHÔNG hợp lệ.");
        }
    }

    public static boolean isBalanced(String expr) {
        Stack<Character> stack = new Stack<>();
        for (char ch : expr.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch); // thêm ngoặc trái vào Stack
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) return false; // thiếu ngoặc trái

                char left = stack.pop();
                if (!isMatchingPair(left, ch)) return false;
            }
        }
        return stack.isEmpty(); // Stack rỗng là ngoặc hợp lệ
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }
}
