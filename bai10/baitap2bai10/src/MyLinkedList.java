public class MyLinkedList<E> {
    private Node<E> head;
    private int numNodes = 0;

    public MyLinkedList() {
        head = null;
    }

    // Thêm vào đầu danh sách
    public void addFirst(E element) {
        Node<E> temp = head;
        head = new Node<>(element);
        head.setNext(temp);
        numNodes++;
    }

    // Thêm vào cuối danh sách
    public void addLast(E element) {
        Node<E> temp = head;
        Node<E> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
        numNodes++;
    }

    // Thêm vào vị trí bất kỳ
    public void add(int index, E element) {
        if (index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        if (index == 0) {
            addFirst(element);
            return;
        }
        Node<E> temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.getNext();
        }
        Node<E> holder = temp.getNext();
        Node<E> newNode = new Node<>(element);
        newNode.setNext(holder);
        temp.setNext(newNode);
        numNodes++;
    }

    // Xóa phần tử tại vị trí index
    public E remove(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        Node<E> temp = head;
        if (index == 0) {
            head = head.getNext();
            numNodes--;
            return temp.getData();
        }
        for (int i = 0; i < index - 1; i++) {
            temp = temp.getNext();
        }
        Node<E> deletedNode = temp.getNext();
        temp.setNext(deletedNode.getNext());
        numNodes--;
        return deletedNode.getData();
    }

    // Xóa phần tử theo giá trị
    public boolean remove(E element) {
        if (head == null) return false;
        if (head.getData().equals(element)) {
            head = head.getNext();
            numNodes--;
            return true;
        }
        Node<E> temp = head;
        while (temp.getNext() != null) {
            if (temp.getNext().getData().equals(element)) {
                temp.setNext(temp.getNext().getNext());
                numNodes--;
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    // Lấy phần tử theo index
    public E get(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp.getData();
    }

    // Lấy phần tử đầu tiên
    public E getFirst() {
        if (head == null) return null;
        return head.getData();
    }

    // Lấy phần tử cuối cùng
    public E getLast() {
        if (head == null) return null;
        Node<E> temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        return temp.getData();
    }

    // Kiểm tra phần tử có trong danh sách hay không
    public boolean contains(E element) {
        return indexOf(element) != -1;
    }

    // Tìm vị trí phần tử
    public int indexOf(E element) {
        Node<E> temp = head;
        for (int i = 0; i < numNodes; i++) {
            if (temp.getData().equals(element)) {
                return i;
            }
            temp = temp.getNext();
        }
        return -1;
    }

    // Trả về số lượng phần tử
    public int size() {
        return numNodes;
    }

    // Sao chép danh sách
    public MyLinkedList<E> clone() {
        MyLinkedList<E> clone = new MyLinkedList<>();
        Node<E> temp = head;
        while (temp != null) {
            clone.addLast(temp.getData());
            temp = temp.getNext();
        }
        return clone;
    }

    // Xóa tất cả phần tử
    public void clear() {
        head = null;
        numNodes = 0;
    }
}
