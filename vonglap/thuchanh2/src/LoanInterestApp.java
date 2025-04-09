import java.util.Scanner;

public class LoanInterestApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số tiền cho vay: ");
        double money = sc.nextDouble();

        System.out.print("Nhập lãi suất tháng (%): ");
        double interestRate = sc.nextDouble();

        System.out.print("Nhập số tháng cho vay: ");
        int months = sc.nextInt();

        double totalInterest = 0;
        for (int i = 1; i <= months; i++) {
            double monthlyInterest = money * interestRate / 100;
            totalInterest += monthlyInterest;
        }

        System.out.println("Tổng tiền lãi sau " + months + " tháng là: " + totalInterest);
    }
}
