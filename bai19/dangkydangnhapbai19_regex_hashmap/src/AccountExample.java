import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountExample {
    private  static final String ACCOUNT_REGEX = "^[a-zA-Z0-9_-]{3,16}$";
    private static final Pattern pattern = Pattern.compile(ACCOUNT_REGEX); // bien dich regex thanh pattern de su dung

    public boolean validate(String account) {
        Matcher matcher = pattern.matcher(account);
        return matcher.matches();
    }
}
