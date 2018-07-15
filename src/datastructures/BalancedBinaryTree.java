package datastructures;

/**
 * A balanced binary tree. Not a search tree or anything, just a tree that remains height balanced.
 */
public class BalancedBinaryTree {
    static class Node {
        public int data;
        public BalancedBinaryTree.Node left;
        public BalancedBinaryTree.Node right;

        public Node() {}

        public Node(int data) {
            this.data = data;
        }
    }

    public BalancedBinaryTree.Node root;

    public BalancedBinaryTree(int rootData) {
        root = new Node(rootData);
    }

    public void addNodeAndBalance(Node newNode) {

    }

    public void addNode(Node newNode) {

    }

    public void balance() {

    }
}
