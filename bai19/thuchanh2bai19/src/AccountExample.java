import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountExample {
    /*Không chứa các ký tự đặc biệt
      Phải dài hơn 6 ký tự
      Không chứa các ký tự viết hoa
      Cho phép dấu gạch dưới (_)
    */
    private static final String ACCOUNT_REGEX = "^[_a-z0-9]{6,}$"; // bieu thuc chinh quy de kiem tra tai khoan

    public AccountExample() {
    }
    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(ACCOUNT_REGEX); // bien dich thanh pattern
        Matcher matcher = pattern.matcher(regex); // kiem tra chuoi dau vao
        return matcher.matches(); // tra ve neu khop chuoi
    }
}
