public class Main {
    public static void main(String[] args) {
        Book[] books = new Book[6];
        books[0] = new ProgrammingBook("P1", "Java Core", 100, "James", "Java", "Spring");
        books[1] = new ProgrammingBook("P2", "C#", 120, "John", "C#", ".NET");
        books[2] = new ProgrammingBook("P3", "JavaScript", 110, "Anna", "JS", "React");

        books[3] = new FictionBook("F1", "Harry Potter", 90, "Rowling", "Fantasy");
        books[4] = new FictionBook("F2", "Viễn tưởng tương lai", 70, "Duy", "Viễn tưởng 1");
        books[5] = new FictionBook("F3", "Robot Tương lai", 60, "Nam", "Viễn tưởng 1");

        double total = 0;
        int countJava = 0, countFiction = 0, countAterSale100 = 0;

        for (Book book : books) {
            total += book.getPrice();

            if (book instanceof ProgrammingBook) {
                ProgrammingBook pb = (ProgrammingBook) book;
                if (pb.getLanguage().equalsIgnoreCase("Java")) {
                    countJava++;
                }
            }

            if (book instanceof FictionBook) {
                FictionBook fb = (FictionBook) book;
                if (fb.getCategory().equalsIgnoreCase("Viễn tưởng 1")) {
                    countFiction++;
                }

                if (fb.getPrice() < 100) {
                    countAterSale100++;
                }
            }
        }

        System.out.println("Tổng số tiền sau 6 cuốn sách: " + total);
        System.out.println("Số sách ProgrammingBook có ngôn ngữ Java: " + countJava);
        System.out.println("Số FictionBook thuộc category Viễn tưởng 1: " + countFiction);
        System.out.println("Số sách Fiction có giá < 100: " + countAterSale100);
    }
}
