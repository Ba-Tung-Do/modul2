public class Personnel {
    private String id;
    private String name;
    private int age;
    private String number;
    private String emaill;

    public Personnel(String id, String name, int age, String number, String emaill) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.number = number;
        this.emaill = emaill;
    }
    public double tinhLuong() {
        return 0;
    }
    @Override
    public String toString() {
        return id + "," + name + "," + age + "," + number + "," + emaill;
    }
}

