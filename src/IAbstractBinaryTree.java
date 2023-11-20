import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;

public interface IAbstractBinaryTree<T> {
    T getKey();

    IAbstractBinaryTree<T> getLeft();

    IAbstractBinaryTree<T> getRight();

    void setLeft(IAbstractBinaryTree<T> left);

    void setRight(IAbstractBinaryTree<T> right);

    void setKey(T key);

    String asIndentedPreOrder(int indent, boolean isRight);

    void printTree();

    void printTreeRecursive(IAbstractBinaryTree<T> current, int depth, String branch);

    List<IAbstractBinaryTree<T>> preOrder();

    List<IAbstractBinaryTree<T>> inOrder();

    List<IAbstractBinaryTree<T>> postOrder();

    Queue<IAbstractBinaryTree<T>> levelOrder();

    void forEachInOrder(Consumer<T> consumer);

    List<IAbstractBinaryTree<T>> depthFirstSearch();

    List<IAbstractBinaryTree<T>> breadthFirstSearch();
}
