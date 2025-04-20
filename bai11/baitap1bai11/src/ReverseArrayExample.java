import java.util.Stack;

public class ReverseArrayExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        Stack<Integer> stack = new Stack<>();

        // Push các phần tử vào stack
        for (int number : numbers) {
            stack.push(number);
        }

        // Pop ra để đảo ngược mảng
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = stack.pop();
        }

        // In mảng sau khi đảo ngược
        System.out.print("Mảng sau khi đảo ngược: ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
