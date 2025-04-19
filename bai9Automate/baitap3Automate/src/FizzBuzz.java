public class FizzBuzz {

    public static String checkFizzBuzz(int number) {
        if (number <= 0) {
            return "Invalid input";
        }

        boolean divisibleBy3 = number % 3 == 0;
        boolean divisibleBy5 = number % 5 == 0;

        if (divisibleBy3 && divisibleBy5) {
            return "FizzBuzz";
        } else if (divisibleBy3) {
            return "Fizz";
        } else if (divisibleBy5) {
            return "Buzz";
        } else {
            return String.valueOf(number);
        }
    }
}
