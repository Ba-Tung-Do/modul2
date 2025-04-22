import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestMap {
    public static void main(String[] args) {

        Map<String, Integer> hashmap = new HashMap<>();
        hashmap.put("Tung", 29);
        hashmap.put("Hieu", 26);
        hashmap.put("Khanh", 22);
        hashmap.put("Tuan", 27);
        System.out.println("Hien thi trong hashmap ");
        System.out.println(hashmap + "\n");

        Map<String,Integer> treeMap = new TreeMap<>(hashmap);
        System.out.println("Hien thi theo thu tu tang dan cua khoa ");
        System.out.println(treeMap);

        Map<String,Integer> linkerHashMap = new LinkedHashMap<>(15, 0.75f, true);
        linkerHashMap.put("Tung", 29);
        linkerHashMap.put("Hieu", 26);
        linkerHashMap.put("Khanh", 22);
        linkerHashMap.put("Tuan", 27);
        System.out.println(" Tuoi cua " + "Tung la :" + linkerHashMap.get("Tung") + "\n");

    }
}
