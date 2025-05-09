import java.util.Stack;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên hệ thập phân: ");
        int number = scanner.nextInt();

        String binary = convertToBinary(number);
        System.out.println("Số nhị phân tương ứng: " + binary);
    }

    public static String convertToBinary(int n) {
        Stack<Integer> stack = new Stack<>();
        if (n == 0) return "0";

        while (n > 0) {
            int remainder = n % 2;
            stack.push(remainder); // lưu phần dư vào stack
            n = n / 2;
        }

        StringBuilder binary = new StringBuilder();
        while (!stack.isEmpty()) {
            binary.append(stack.pop());
        }

        return binary.toString();
    }
}
