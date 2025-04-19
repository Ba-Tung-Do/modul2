// Khai báo lớp MyList có kiểu dữ liệu generic E (Element)
public class MyList<E> {
    // Thuộc tính số lượng phần tử hiện có trong danh sách
    private int size = 0;
    // Dung lượng mảng mặc định khi khởi tạo
    private static final int DEFAULT_CAPACITY = 10;
    // Mảng lưu trữ các phần tử
    private Object[] elements;

    // Constructor không tham số, khởi tạo mảng với dung lượng mặc định
    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    // Constructor có tham số, cho phép tự truyền dung lượng
    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    // Thêm phần tử tại vị trí bất kỳ
    public void add(int index, E element) {
        ensureCapacity(size + 1); // Kiểm tra và mở rộng mảng nếu cần
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        // Dịch chuyển các phần tử từ vị trí index sang phải 1 ô để chèn phần tử mới
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++; // Tăng số lượng phần tử
    }

    // Thêm phần tử vào cuối danh sách
    public boolean add(E element) {
        ensureCapacity(size + 1); // Kiểm tra dung lượng
        elements[size++] = element; // Gán phần tử và tăng size
        return true;
    }

    // Xóa phần tử tại chỉ số index, trả về phần tử bị xóa
    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        E oldValue = (E) elements[index]; // Lưu lại phần tử cần xóa
        int numMoved = size - index - 1; // Số lượng phần tử cần dịch chuyển
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null; // Giảm size và xóa phần tử cuối để tránh memory leak
        return oldValue;
    }

    // Trả về số lượng phần tử đang lưu trữ
    public int size() {
        return size;
    }

    // Tạo một bản sao hoàn chỉnh của danh sách
    public MyList<E> clone() {
        MyList<E> clone = new MyList<>(elements.length);
        for (int i = 0; i < size; i++) {
            clone.add((E) elements[i]);
        }
        return clone;
    }

    // Kiểm tra xem danh sách có chứa phần tử o hay không
    public boolean contains(E o) {
        return indexOf(o) >= 0;
    }

    // Tìm vị trí đầu tiên xuất hiện phần tử o
    public int indexOf(E o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (elements[i] == null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(elements[i]))
                    return i;
        }
        return -1; // Không tìm thấy
    }

    // Đảm bảo dung lượng mảng đủ để chứa minCapacity phần tử
    public void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = elements.length * 2; // Tăng gấp đôi dung lượng
            if (newCapacity < minCapacity)
                newCapacity = minCapacity;
            Object[] newElements = new Object[newCapacity];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }

    // Lấy phần tử tại vị trí i
    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + i);
        }
        return (E) elements[i];
    }

    // Xóa toàn bộ danh sách
    public void clear() {
        for (int i = 0; i < size; i++)
            elements[i] = null; // Giải phóng bộ nhớ
        size = 0; // Reset kích thước
    }
}
