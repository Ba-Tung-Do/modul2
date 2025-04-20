import java.util.Stack;

public class ReverseStringExample {
    public static void main(String[] args) {
        String input = "hello";
        Stack<Character> stack = new Stack<>();

        // Push từng ký tự vào stack
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        // Pop ra để tạo chuỗi đảo ngược
        String reversed = "";
        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        System.out.println("Chuỗi sau khi đảo ngược: " + reversed);
    }
}
