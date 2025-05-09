public class Payment {
    public static boolean xuLyThanhToan() {
        try {
            System.out.print("Đang xử lý thanh toán");
            for (int i = 0; i < 3; i++) {
                Thread.sleep(700);
                System.out.print(".");
            }
            System.out.println("\nThanh toán thành công!");
            return true;
        } catch (InterruptedException e) {
            System.out.println("Lỗi khi xử lý thanh toán");
            return false;
        }
    }
}
