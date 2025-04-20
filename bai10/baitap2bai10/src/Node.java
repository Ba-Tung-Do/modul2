public class Node {
    private Node<E> next;
    private E data;

    public Node(E data){
        this.data = data;
        this.next = null;
    }
    public E getData(){
        return data;
    }
    public Node<E> getNext(){
        return next;
    }
    public void setNext(Node<E>){
        this.next = next;
    }
}
