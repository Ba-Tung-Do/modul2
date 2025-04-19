public class MyListTest {
    public static void main(String[] args) {
        MyList<String> myList = new MyList<>();

        // Thêm phần tử
        myList.add("Apple");
        myList.add("Banana");
        myList.add("Cherry");

        // In ra các phần tử
        for (int i = 0; i < myList.size(); i++) {
            System.out.println("Element at index " + i + ": " + myList.get(i));
        }

        // Test remove
        System.out.println("\nRemove element at index 1: " + myList.remove(1));

        // In lại danh sách sau remove
        for (int i = 0; i < myList.size(); i++) {
            System.out.println("Element at index " + i + ": " + myList.get(i));
        }

        // Test clone
        MyList<String> cloneList = myList.clone();
        System.out.println("\nCloned List:");
        for (int i = 0; i < cloneList.size(); i++) {
            System.out.println("Element at index " + i + ": " + cloneList.get(i));
        }

        // Test contains
        System.out.println("\nContains 'Apple'? " + myList.contains("Apple"));
        System.out.println("Index of 'Apple': " + myList.indexOf("Apple"));
    }
}
