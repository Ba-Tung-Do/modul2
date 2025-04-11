public class Main2 {
    public static void main(String[] args) {
        DemoStatic demo = new DemoStatic();
//        nonstatic phai truy cap thong qua doi tuong
        demo.id = 100;
// static truy cap thong qua ten lop
        demo.max = 100;
        m1();
    }

    public static void m1(){}
}
