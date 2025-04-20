public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<String> myList = new MyLinkedList<>();

        myList.addFirst("A");
        myList.addLast("B");
        myList.add(1, "C"); // Insert "C" vào giữa A và B

        System.out.println("Danh sách ban đầu:");
        for (int i = 0; i < myList.size(); i++) {
            System.out.print(myList.get(i) + " ");
        }

        System.out.println("\nXóa phần tử C:");
        myList.remove("C");

        for (int i = 0; i < myList.size(); i++) {
            System.out.print(myList.get(i) + " ");
        }

        System.out.println("\nClone danh sách:");
        MyLinkedList<String> cloneList = myList.clone();
        for (int i = 0; i < cloneList.size(); i++) {
            System.out.print(cloneList.get(i) + " ");
        }
    }
}
