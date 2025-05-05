import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailExample {
    private static Pattern pattern; // bien static chua mau regex de check email
    private  Matcher matcher; // kiem tra chuoi co khop hay khong
// bieu thuc chinh quy (regex) dung de kiem tra gmail
    private static final String EMAIL_REGEX =  "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
// constructor khi tao emailexamle se bien dich regex thanh pattern
    public EmailExample() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }
    // ham validate kiem tra chuoi dau vao
    public boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
