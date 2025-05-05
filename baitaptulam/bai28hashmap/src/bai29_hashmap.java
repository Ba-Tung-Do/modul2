import java.util.HashMap;

public class bai29_hashmap {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        HashMap<Integer, Float> map2 = new HashMap<>();

        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");

        // lay gia tri cua phan tu
        String value = map.get(1);
        String value2 = map.get(2);
        String value3 = map.get(3);
        System.out.println(value);
        System.out.println(value2);
        System.out.println(value3);
        // xoa phan tu trong hash map
        map.remove(2);
        System.out.println(map.get(2));
        // kiem tra xem co ton tai phan tu khong
        boolean check = map.containsKey(4);
        System.out.println(check);
        // kiem tra xem co gia tri ton tai trong map hay khong
        boolean check2 = map.containsKey("Orange");
        System.out.println(check2);
        // kiem tra xem hashmap co rong khong ?
        boolean rong = map.isEmpty();
        System.out.println(rong);
        // lay so luong phan tu
        int soLuong = map.size();
        System.out.println(soLuong);
        // duyet hashmap
        for (Integer key : map.keySet()) {
            String vl = map.get(key);
            System.out.println(key + " " + vl);
        }
    }
}
