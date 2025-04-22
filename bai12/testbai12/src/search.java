public class search(E element) {
    TreeNode<E> current = root;

    while (current != null) {
        if (element < current.element) {
            current = current.left;
        } else if (element > current.element) {
            current = current.right;
        } else
            return true ;
    }
    return false;
}
