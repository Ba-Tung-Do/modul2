import java.util.Scanner;

public class danhsachsv {
    public static void main(String[] args) {
        String[] student = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory"};
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the student name to search: ");
        String input_name = scanner.nextLine();

        boolean isExist = false;
        for (int i = 0; i < student.length; i++) {
            if (student[i].equalsIgnoreCase(input_name)) {
                System.out.println("Position of the student in the list \"" + input_name + "\" is: " + i);
                isExist = true;
                break;
            }
        }

        if (!isExist) {
            System.out.println("Not found \"" + input_name + "\" in the list.");
        }

        scanner.close();
    }
}
