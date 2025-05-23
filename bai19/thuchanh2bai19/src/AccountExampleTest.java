public class AccountExampleTest {

    private static AccountExample accountExample; // khai bao bien

    public static final String[] validAccount = new String[]{"123abc_", "_abc123", "______", "123456", "abcdefgh"};
    public static final String[] invalidAccount = new String[]{".@", "12345", "1234_", "abcde"};

    public static void main(String args[]) {
        accountExample = new AccountExample(); // goi lai bien trong main de chay chuong trinh
        for (String account : validAccount) { // vong lap kiem tra tai khoan hop le
            boolean isValid = accountExample.validate(account);
            System.out.println("Account is " + account + " is valid: " + isValid);
        }
        for (String account : invalidAccount) { // vong lap kiem tra tai khoan khong hop le
            boolean isValid = accountExample.validate(account);
            System.out.println("Account is " + account + " is valid: " + isValid);
        }
    }
}