import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap vao mot chuoi bat ky :");
        String string = input.nextLine();

        ArrayList<Character> charList = new ArrayList<>();
        for (char c : string.toCharArray()) {
            charList.add(c);
        }
        for (int i = 0; i < charList.size()-1; i++) { // tim phan tu lon nhat trong day
            for (int j = 0; j < charList.size()-i-1; j++) { // so sanh 2 phan tu de tim phan tu lon hon
                if (charList.get(j) > charList.get(j+1)) { // neu phan tu j lon hon "j + 1"
                     char temp = charList.get(j);  // gan temp bang j , doi cho j thanh j + 1 va tra "j + 1 " ve vi tri cua j
                     charList.set(j, charList.get(j+1));
                     charList.set(j+1, temp);
                }
            }
        }
        String result = "";
        for (int i = 0; i < charList.size(); i++) {
            result += charList.get(i) + " ";
        }
        System.out.println("Chuoi sau khi sap xep " + result);
    }
}