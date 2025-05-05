import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class bai28_7giabt32 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(1,9,3,14,5,27,8));
        ArrayList<Integer> copy = new ArrayList<>(list);
        System.out.println(copy);
        Collections.sort(copy);
        System.out.println("sau sap xep" + copy);
        // in ra so lon thu 2 va so nho thu 2 trong list
        int soLonThu2 = copy.get(copy.size()-2);
        int soNhoThu2 = copy.get(1);
        System.out.println(" so lon thu 2 trong list la :" + " " + soLonThu2);
        System.out.println(" so nho thu 2 trong list la :" + " " + soNhoThu2);
        System.out.println("vi tri cua so lon thu 2 trong list la :"+ " " + list.indexOf(soLonThu2));
        System.out.println("vi tri cua so nho thu 2 trong list la :"+ " " + list.indexOf(soNhoThu2));
    }
}
