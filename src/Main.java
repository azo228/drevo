import java.util.*;


public class Main {
    public static void main(String[] args) {
        IAbstractBinaryTree<Integer> tree = buildTree();
        tree.printTreeRecursive(tree, 0, "───");
        System.out.println("\n\n\n\n");

        System.out.println("Level-order traversal:");
        Queue<IAbstractBinaryTree<Integer>> levelOrderList = tree.levelOrder();
        for (var node : levelOrderList) {
            System.out.print(node.getKey() + " ");
        }
        System.out.println();

        System.out.println("In-order traversal:");
        List<IAbstractBinaryTree<Integer>> inOrderList = tree.inOrder();
        for (var node : inOrderList) {
            System.out.print(node.getKey() + " ");
        }
        System.out.println();

        System.out.println("Pre-order traversal:");
        List<IAbstractBinaryTree<Integer>> preOrderList = tree.preOrder();
        for (var node : preOrderList) {
            System.out.print(node.getKey() + " ");
        }
        System.out.println();

        System.out.println("Post-order traversal:");
        List<IAbstractBinaryTree<Integer>> postOrderList = tree.postOrder();
        for (var node : postOrderList) {
            System.out.print(node.getKey() + " ");
        }
        System.out.println();

        System.out.println("BFS traversal:");
        List<IAbstractBinaryTree<Integer>> bfs = tree.breadthFirstSearch();
        for (var node : bfs) {
            System.out.print(node.getKey() + " ");
        }
        System.out.println();

        System.out.println("DFS traversal:");
        List<IAbstractBinaryTree<Integer>> dfs = tree.depthFirstSearch();
        for (var node : dfs) {
            System.out.print(node.getKey() + " ");
        }
        System.out.println();
    }

    private static IAbstractBinaryTree<Integer> buildTree() {
        IAbstractBinaryTree<Integer> tree = (IAbstractBinaryTree<Integer>) new BinaryTree<>(6);

        // Level 1
        tree.setLeft((IAbstractBinaryTree<Integer>) new BinaryTree<>(4));
        tree.setRight((IAbstractBinaryTree<Integer>) new BinaryTree<>(8));

        // Level 2
        tree.getLeft().setLeft((IAbstractBinaryTree<Integer>) new BinaryTree<>(3));
        tree.getLeft().setRight((IAbstractBinaryTree<Integer>) new BinaryTree<>(5));

        tree.getRight().setLeft((IAbstractBinaryTree<Integer>) new BinaryTree<>(7));
        tree.getRight().setRight((IAbstractBinaryTree<Integer>) new BinaryTree<>(9));

        // Level 3
        tree.getLeft().getLeft().setLeft((IAbstractBinaryTree<Integer>) new BinaryTree<>(1));
        tree.getLeft().getLeft().setRight((IAbstractBinaryTree<Integer>) new BinaryTree<>(5));

        tree.getLeft().getRight().setLeft((IAbstractBinaryTree<Integer>) new BinaryTree<>(4));
        tree.getLeft().getRight().setRight((IAbstractBinaryTree<Integer>) new BinaryTree<>(7));

        tree.getRight().getLeft().setLeft((IAbstractBinaryTree<Integer>) new BinaryTree<>(7));
        tree.getRight().getLeft().setRight((IAbstractBinaryTree<Integer>) new BinaryTree<>(10));

        tree.getRight().getRight().setLeft((IAbstractBinaryTree<Integer>) new BinaryTree<>(9));
        tree.getRight().getRight().setRight((IAbstractBinaryTree<Integer>) new BinaryTree<>(12));

        tree.getLeft().getLeft().getLeft().setLeft(new BinaryTree<>(1));
        tree.getLeft().getLeft().getLeft().setRight(new BinaryTree<>(2));

        tree.getLeft().getLeft().getRight().setLeft(new BinaryTree<>(3));
        tree.getLeft().getLeft().getRight().setRight(new BinaryTree<>(4));

        tree.getLeft().getRight().getLeft().setLeft(new BinaryTree<>(5));
        tree.getLeft().getRight().getLeft().setRight(new BinaryTree<>(6));

        tree.getLeft().getRight().getRight().setLeft(new BinaryTree<>(7));
        tree.getLeft().getRight().getRight().setRight(new BinaryTree<>(8));

        tree.getRight().getLeft().getLeft().setLeft(new BinaryTree<>(9));
        tree.getRight().getLeft().getLeft().setRight(new BinaryTree<>(10));

        tree.getRight().getLeft().getRight().setLeft(new BinaryTree<>(11));
        tree.getRight().getLeft().getRight().setRight(new BinaryTree<>(12));

        tree.getRight().getRight().getLeft().setLeft(new BinaryTree<>(13));
        tree.getRight().getRight().getLeft().setRight(new BinaryTree<>(14));

        tree.getRight().getRight().getRight().setLeft(new BinaryTree<>(15));
        tree.getRight().getRight().getRight().setRight(new BinaryTree<>(16));
        return tree;
    }
}
