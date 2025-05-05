import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlDanTri {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://dantri.com.vn/the-gioi.htm");
            // khởi tạo đường dẫn
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream())); //
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            // close scanner
            scanner.close();
            // xoa cac ky tu xuong dong
            content = content.replaceAll("\\n+", "");
            // tạo biểu thức chính quy
            Pattern p = Pattern.compile("article-title\"><a[^>]*>(.*?)</a>");
            Matcher m = p.matcher(content);
            while (m.find()) {
                System.out.println(m.group(1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}