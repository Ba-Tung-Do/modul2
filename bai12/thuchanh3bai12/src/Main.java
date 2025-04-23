import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Main {
    public static void main (String[] args){
        Student student = new Student ("Kien",30,"HT");
        Student student1 = new Student ("Nam",29,"HT");
        Student student2 = new Student ("Nam",28,"HT");
        Student student3 = new Student ("Tung",27,"HT");

        List<Student> lists = new ArrayList<Student>();
        lists.add(student);
        lists.add(student1);
        lists.add(student2);
        lists.add(student3);
        Collections.sort(lists);
        for (Student s : lists) {
            System.out.println(s.toString());
        }
        AgeComparator ageComparator = new AgeComparator();
        Collections.sort(lists, ageComparator);
        System.out.println("So sanh theo so tuoi ");
        for (Student s : lists) {
            System.out.println(s.toString());
        }
    }
}
