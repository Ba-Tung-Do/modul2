import java.util.Scanner;
public class doitien {
    public static void main(String[] args) {
        double vnd = 26000;
        double usd;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter usd: ");
        usd = sc.nextDouble();
        double quydoi= usd * vnd;
        System.out.print("Tien viet nam dong " + quydoi);
    }
}
