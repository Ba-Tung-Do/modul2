public class ProgrammingBook extends Book {
    private String language;
    private String framework;

    public ProgrammingBook(String bookCode, String name, double price, String author, String language, String framework) {
       super(bookCode, name, price, author);
       this.language = language;
       this.framework = framework;

    }
    public double getPrice() {
        return super.getPrice() * 0.95;

    }
    public String getLanguage() {
        return language;
    }
}