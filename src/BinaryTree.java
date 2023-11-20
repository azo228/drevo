import java.util.*;
import java.util.function.Consumer;


public class BinaryTree<T> implements IAbstractBinaryTree<T> {
    private T key;
    private IAbstractBinaryTree<T> left;
    private IAbstractBinaryTree<T> right;

    public BinaryTree(T key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }

    @Override
    public T getKey() {
        return key;
    }

    @Override
    public IAbstractBinaryTree<T> getLeft() {
        return left;
    }

    @Override
    public IAbstractBinaryTree<T> getRight() {
        return right;
    }

    @Override
    public void setLeft(IAbstractBinaryTree<T> left) {
        this.left = left;
    }

    @Override
    public void setRight(IAbstractBinaryTree<T> right) {
        this.right = right;
    }

    @Override
    public void setKey(T key) {
        this.key = key;
    }

     @Override
    public String asIndentedPreOrder(int indent, boolean isRight) {
        StringBuilder result = new StringBuilder(" ".repeat(indent * 2));

        if (indent > 0) {
            result.append(isRight ? "└─ " : "├─ ");
        }

        result.append(key.toString()).append(System.lineSeparator());

        if (left != null || right != null) {
            if (right != null)
                result.append(right.asIndentedPreOrder(indent + 1, left == null));

            if (left != null)
                result.append(left.asIndentedPreOrder(indent + 1, false));
        }

        return result.toString();
    }

    @Override
    public void printTree() {
        printTreeRecursive(this, 0, "───");
    }

    @Override
    public void printTreeRecursive(IAbstractBinaryTree<T> current, int depth, String branch) {
        if (current == null) {
            return;
        }

        printTreeRecursive(current.getRight(), depth + 1, "┌──");
        System.out.println(" ".repeat(depth * 4) + branch + current.getKey());
        printTreeRecursive(current.getLeft(), depth + 1, "└──");
    }

    @Override
    public List<IAbstractBinaryTree<T>> preOrder() {
        List<IAbstractBinaryTree<T>> result = new ArrayList<>();
        result.add(this);

        if (left != null)
            result.addAll(left.preOrder());

        if (right != null)
            result.addAll(right.preOrder());

        return result;
    }

    @Override
    public List<IAbstractBinaryTree<T>> inOrder() {
        List<IAbstractBinaryTree<T>> result = new ArrayList<>();

        if (left != null)
            result.addAll(left.inOrder());

        result.add(this);

        if (right != null)
            result.addAll(right.inOrder());

        return result;
    }

    @Override
    public List<IAbstractBinaryTree<T>> postOrder() {
        List<IAbstractBinaryTree<T>> result = new ArrayList<>();

        if (left != null)
            result.addAll(left.postOrder());

        if (right != null)
            result.addAll(right.postOrder());

        result.add(this);

        return result;
    }

    @Override
    public Queue<IAbstractBinaryTree<T>> levelOrder() {
        Queue<IAbstractBinaryTree<T>> queue = new LinkedList<>();
        queue.add(this);

        while (!queue.isEmpty()) {
            IAbstractBinaryTree<T> current = queue.poll();
            System.out.print(current.getKey() + " ");

            if (current.getLeft() != null)
                queue.add(current.getLeft());

            if (current.getRight() != null)
                queue.add(current.getRight());
        }

        return queue;
    }

    @Override
    public void forEachInOrder(Consumer<T> consumer) {
        if (left != null)
            left.forEachInOrder(consumer);

        consumer.accept(key);

        if (right != null)
            right.forEachInOrder(consumer);
    }

    @Override
    public List<IAbstractBinaryTree<T>> depthFirstSearch() {
        List<IAbstractBinaryTree<T>> result = new ArrayList<>();
        Stack<IAbstractBinaryTree<T>> stack = new Stack<>();
        Set<IAbstractBinaryTree<T>> visited = new HashSet<>();

        stack.push(this);

        while (!stack.isEmpty()) {
            IAbstractBinaryTree<T> current = stack.peek();

            if (current.getLeft() != null && !visited.contains(current.getLeft())) {
                stack.push(current.getLeft());
            } else if (current.getRight() != null && !visited.contains(current.getRight())) {
                stack.push(current.getRight());
            } else {
                stack.pop();
                result.add(current);
                visited.add(current);
            }
        }

        return result;
    }


    @Override
    public List<IAbstractBinaryTree<T>> breadthFirstSearch() {
        List<IAbstractBinaryTree<T>> result = new ArrayList<>();
        Queue<IAbstractBinaryTree<T>> queue = new LinkedList<>();

        queue.add(this);

        while (!queue.isEmpty()) {
            IAbstractBinaryTree<T> current = queue.poll();
            result.add(current);

            if (current.getLeft() != null)
                queue.add(current.getLeft());

            if (current.getRight() != null)
                queue.add(current.getRight());
        }

        return result;
    }
}

