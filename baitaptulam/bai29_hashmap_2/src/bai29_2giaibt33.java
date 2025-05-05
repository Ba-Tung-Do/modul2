import java.util.HashMap;
import java.util.Scanner;

public class bai29_2giaibt33 {
    public static void main(String[] args) {
       HashMap<String ,String> users = new HashMap<>();
       users.put("user1" , "123456");
       users.put("user2" , "123456");
       users.put("user3" , "123456");
       users.put("user4" , "123456");
       users.put("user5" , "1234567");
       users.put("user6" , "123456");
       users.put("user8" , "123456");
       users.put("user9" , "123456");
       users.put("user10" , "123456");

       Scanner sc = new Scanner(System.in);
       System.out.println("nhap vao ten dang nhap : ");
       String userName = sc.nextLine();
       System.out.println("nhap vao mat khau : ");
       String password = sc.nextLine();

       // kiem tra
       if (!users.containsKey(userName)) { // kiem tra ten dang nhap co ton tai khong
           System.out.println("Ten dang nhap khong chinh xac ! ");
       }
       else  if (!users.get(userName).equals(password)) { // kiem tra xem mat khau co dung khong
           System.out.println("Mat khau khong dung ! ");
       }
       else {
           System.out.println("Ban dang nhap thanh cong !  "); // in ra ket qua neu dung thi dang nhap thanh cong
       }

    }
}
