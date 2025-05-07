public class Main {
    public static void main(String[] args) {
        Gun gun = new Gun();

        System.out.println("Start game...");

        // gun.fire();           //  TH1: Không dùng Pool
        gun.fireInPool();        // TH2: Dùng Pool

        System.out.println("Game Over.");
        System.out.println("Total bullet created: " + Bullet.count);
    }
}
