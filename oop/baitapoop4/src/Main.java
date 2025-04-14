public class Main {
    public static void main(String[] args) {
        // Fan 1: tốc độ cao nhất, radius 10, màu vàng, đang bật
        Fan fan1 = new Fan();
        fan1.setSpeed(Fan.FAST);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOn(true);

        // Fan 2: tốc độ trung bình, radius 5, màu xanh, đang tắt
        Fan fan2 = new Fan();
        fan2.setSpeed(Fan.MEDIUM);
        fan2.setRadius(5);
        fan2.setColor("blue");
        fan2.setOn(false);

        // In kết quả
        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
}
