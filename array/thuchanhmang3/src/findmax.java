import java.util.Scanner;

public class findmax {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in); // nhap thong tin tu ban phim
        do {
            System.out.print("Enter a size:"); // vong lap nhap ky tu mang
            size = scanner.nextInt();
            if (size > 20)
                System.out.println("Size should not exceed 20");
        } while (size > 20);

        array = new int[size];  // in ra mang moi
        int i = 0;
        while (i < array.length) {
            System.out.print("Enter element " + (i+1) + ":");
            array[i] = scanner.nextInt();
            i++;
        }
        System.out.print("Property list: "); // in ra mang moi
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }

        int max = array[0];  // gan max bang vi tri 0
        int index = 1;
        for (int j = 0; j < array.length; j++) {   // chay vong lap xac dinh max
            if (array[j] > max) {
                max = array[j];
                index = j + 1;
            }
        }
        System.out.println("Gia tri lon nhat " + max + " ,nam o vi tri so  " + index); // in ra ket qua
    }
}
