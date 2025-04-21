import java.util.LinkedList;

public class Queue {
    private Node  front;
    private Node  rear;

    public Queue() {
        front = null;
        rear = null;
    }
    public Queue(Node front, Node rear) {
        this.front = front;
        this.rear = rear;
    }

    public void enqueue(int data) { // them vao cuoi hang doi
        Node newNode = new Node(data, null);

        if (front == null) {
            front = newNode; // front va rear deu chi vao node moi
            rear = newNode; //
            rear.next = front; //rear.next tro lai front de tao vong tron
        } else {
            rear.next = newNode; // tao rear moi tai node cuoi
            rear = newNode; // cap nhat rear = node moi
            rear.next = front;  // rear moi noi lai front tao vong lap
        }
    }
    // xoa phan tu dau  hang doi
    public int dequeue() {
        if (front == null) {
            System.out.println("Hang doi trong ! ");
        }
        int value;
        if (front == rear) { // neu chi co 1 phan tu
            value = front.data; // gia tri xoa bang phan tu dau
            front = null; // don sach front va rear vi chi co 1 phan tu
            rear = null;
        } else {
            value = front.data; // lu gia tri node dau tien
            front = front.next; // di chuyen front xuong node tiep theo
            rear.next = front; // gan rear tro toi front moi
        }
        return value;
    }
    // hien thi toan bo phan tu trong hang doi
    public void displayQueue() {
        if (front == null) {
            System.out.println("Hang doi trong ! ");
            return;
        }
        System.out.println("Phan tu co trong hang doi ");
        Node temp = front;
        do {
            System.out.println(temp.data +" ");
            temp = temp.next;
        } while (temp != front);
        System.out.println();
    }
}
