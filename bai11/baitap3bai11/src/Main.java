public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        queue.displayQueue();
        System.out.println("Phan tu bi xoa la :" + queue.dequeue() ); // in ra pha tu bi xoa
        queue.displayQueue(); // hien thi mang sau khi bi xoa
        queue.enqueue(5); // them 5 vao hang doi
        queue.displayQueue(); // in ra hang doi
    }
}