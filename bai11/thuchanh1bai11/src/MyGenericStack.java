import java.util.EmptyStackException;
import java.util.LinkedList;
// tao lop stack
public class MyGenericStack<T> {
    private LinkedList<T> stack;

    public MyGenericStack() {
        stack = new LinkedList<>();
    }
    // tao phuong thuc push
    public void push(T element){
        stack.push(element);
    }
    // tao phuong thuc pop
    public T pop(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return stack.removeFirst();
    }
    // tao phuong thuc size()
    public int size(){
        return stack.size();
    }
    // tao phuong thuc empty
    public boolean isEmpty(){
        if (stack.size() == 0){
            return true;
        }
        return false;
    }
}
