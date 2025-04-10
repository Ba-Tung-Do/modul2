import java.util.Scanner;

public class Xoaphantukhoimang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array ={10,4,6,7,8,6,0,0,0,0};
        int size = 6;

        System.out.print("Nhap phan tu can xoa : ");
        int x = scanner.nextInt();

        int index_del = -1;
        for(int i = 0; i < size; i++){
            if(x == array[i]){
                index_del = i;
                break;
            }
        }
        if(index_del == -1){
            System.out.println("Khong tim thay phan tu " + x + " trong mang .");
        } else {
            for (int i = index_del; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            array[size - 1] = 0;
            size --;

            System.out.print("Mang sau khi xoa phan tu " + x + " :  ");
            for(int i = 0; i < array.length; i++){
                System.out.print(array[i] + " ");
            }
        }
    }
}