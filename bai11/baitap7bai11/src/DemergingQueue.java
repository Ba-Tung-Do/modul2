import java.util.*;
import java.text.*;


public class DemergingQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<NhanVien> danhSach = new ArrayList<>();

        System.out.print("Nhập số lượng nhân viên: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("--- Nhập nhân viên thứ " + (i + 1) + " ---");
            System.out.print("Họ tên: ");
            String hoTen = sc.nextLine();

            String gioiTinh;
            do {
                System.out.print("Giới tính (Nam/Nu): ");
                gioiTinh = sc.nextLine().toLowerCase();
            } while (!gioiTinh.equals("nam") && !gioiTinh.equals("nu"));

            String ngaySinh = null;
            while (true) {
                System.out.print("Ngày sinh (định dạng yyyy-MM-dd): ");
                ngaySinh = sc.nextLine();
                if (isValidDate(ngaySinh)) break;
                else System.out.println(" Sai định dạng! Hãy nhập lại theo yyyy-MM-dd.");
            }

            danhSach.add(new NhanVien(hoTen, gioiTinh, ngaySinh));
        }

        Queue<NhanVien> queueNu = new LinkedList<>();
        Queue<NhanVien> queueNam = new LinkedList<>();

        for (NhanVien nv : danhSach) {
            if (nv.gioiTinh.equals("nu")) {
                queueNu.add(nv);
            } else {
                queueNam.add(nv);
            }
        }

        System.out.println("\n DANH SÁCH SAU KHI DEMERGING:");
        while (!queueNu.isEmpty()) System.out.println(queueNu.poll());
        while (!queueNam.isEmpty()) System.out.println(queueNam.poll());
    }

    public static boolean isValidDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        try {
            Date date = sdf.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
