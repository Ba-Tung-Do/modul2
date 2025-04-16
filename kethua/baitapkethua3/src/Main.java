public class Main {
    public static void main(String[] args) {
        MovablePoint mp = new MovablePoint();

        mp.setXY(1.0f, 1.0f);

        mp.setxSpeed(0.5f);
        mp.setySpeed(0.5f);

        System.out.println("truoc khi di chuyen:" + mp);
        mp.move();
        System.out.println("Sau khi di chuyen:" + mp);
    }
}
