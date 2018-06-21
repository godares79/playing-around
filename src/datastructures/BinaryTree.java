package datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * Very simple binary tree.
 * Not a search tree or balanced tree or anything like that.
 */
public class BinaryTree {
    static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int data) {
            this.data = data;
        }
    }

    public Node root;

    public BinaryTree() {
        root = new Node();
    }

    public BinaryTree(int rootData) {
        root = new Node(rootData);
    }

    public List<Integer> inOrderTraversal() {
        // Print the contents of the tree in order.
        List<Integer> traversal = new ArrayList<>();
        inOrderTraversalHelper_Recursive(root, traversal);
        return traversal;
    }

    private void inOrderTraversalHelper_Recursive(Node root, List<Integer> traversal) {
        if (root == null) return;
        inOrderTraversalHelper_Recursive(root.left, traversal);
        traversal.add(root.data);
        inOrderTraversalHelper_Recursive(root.right, traversal);
    }

    public List<Integer> postOrderTraversal() {
        // Print the contents of the tree post order.
        List<Integer> traversal = new ArrayList<>();
        postOrderTraversalHelper_Recursive(root, traversal);
        return traversal;
    }

    private void postOrderTraversalHelper_Recursive(Node root, List<Integer> traversal) {
        if (root == null) return;
        postOrderTraversalHelper_Recursive(root.left, traversal);
        postOrderTraversalHelper_Recursive(root.right, traversal);
        traversal.add(root.data);
    }

    public List<Integer> preOrderTraversal() {
        // Print the contents of the tree pre order.
        List<Integer> traversal = new ArrayList<>();
        preOrderTraversalHelper_Recursive(root, traversal);
        return traversal;
    }

    private void preOrderTraversalHelper_Recursive(Node root, List<Integer> traversal) {
        if (root == null) return;
        traversal.add(root.data);
        preOrderTraversalHelper_Recursive(root.left, traversal);
        preOrderTraversalHelper_Recursive(root.right, traversal);
    }
}
