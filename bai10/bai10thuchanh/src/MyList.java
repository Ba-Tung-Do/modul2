public class MyList {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;  // khai bao hang so dung luong = 10
    private Object[] elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];  // hang so dung luong = 10 ;
    }

    public void ensureCapa() {
        int  newSize = elements.length * 2;
    }
    public void add(E e) {
        if (size == elements.length) {
            ensureCapa() ;
        }
        elements[size++] = e;
    }
    public E get(int i){
        if (i>= size || i<0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
    } return (E) element[i];
}
