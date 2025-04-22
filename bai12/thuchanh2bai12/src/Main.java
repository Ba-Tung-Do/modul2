import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main{
    public static void main(String[] args) {
        Student student1 = new Student("nam",20,"ha noi");
        Student student2 = new Student ("Hung",21,"Nam dinh");
        Student student3 = new Student ("Ha",21,"Bac ninh");

        Map<Integer,Student> studentsMap = new HashMap<>();
        studentsMap.put(1,student1);
        studentsMap.put(2,student2);
        studentsMap.put(3,student3);
        studentsMap.put(4,student1);

        for(Map.Entry<Integer,Student> student : studentsMap.entrySet()){
            System.out.println(student.toString());
        }

        System.out.println("........Set");
        Set<Student> students = new HashSet<Student>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student1);

        for(Student student : students){
            System.out.println(student.toString());
        }
    }
}