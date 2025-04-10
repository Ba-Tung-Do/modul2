class Student {
    String id;
    String fullname;
    String email;
    int age;
    double grade;

    public Student(String id, String fullname, String email, int age, double grade) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.age = age;
        this.grade = grade;
    }
}

public class Main {
    public static void main(String[] args) {
        // Tao mang 5 sinh vien
        Student[] students = new Student[5];
        students[0] = new Student("S01", "Nguyen Van A", "a@gmail.com", 20, 6.5);
        students[1] = new Student("S02", "Nguyen Van B", "b@gmail.com", 22, 4.0);
        students[2] = new Student("S03", "Nguyen Van C", "c@gmail.com", 21, 7.0);
        students[3] = new Student("S04", "Nguyen Van D", "d@gmail.com", 23, 5.5);
        students[4] = new Student("S05", "Nguyen Van E", "e@gmail.com", 20, 3.0);

        double totalAge = 0;
        for (Student s : students) {
            totalAge += s.age;
        }
        double avgAge = totalAge / students.length;
        System.out.println("Tuoi trung binh cua sinh vien: " + avgAge);

        int countPass = 0;
        for (Student s : students) {
            if (s.grade > 5) {
                countPass++;
            }
        }
        System.out.println("So sinh vien dat (grade > 5): " + countPass);

        for (Student s : students) {
            if (s.fullname.equals("Nguyen Van A")) {
                System.out.println("Email Nguyen Van A: " + s.email);
                break;
            }
        }
    }
}
