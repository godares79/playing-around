package datastructures;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

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
        // Print the contents of the tree in order: left -> root -> right
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
        // Print the contents of the tree post order: left -> right -> root
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
        // Print the contents of the tree pre order: root -> left -> right
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

    public List<Integer> inOrderTraversal_Iterative() {
        Stack<Node> nodeStack = new Stack<>();
        List<Integer> traversal = new ArrayList<>();

        if (root == null) return traversal;
        Node newRoot = root;
        while (true) {
            while (newRoot != null) {
                nodeStack.push(newRoot);
                newRoot = newRoot.left;
            }
            Node current = nodeStack.pop();
            traversal.add(current.data);
            if (current.right != null) {
                newRoot = current.right;
                continue;
            }

            if (nodeStack.isEmpty()) return traversal;
        }
    }

    /*
     * Just using a Stack and adding continues in the loop to emulate the recursion is not enough... nodes end up
     * being readded in subsequent loops. However, adding a Set to hold the visited nodes is enough to get the
     * algorithm working.
     */
    public List<Integer> postOrderTraversalHelper_Iterative_ExtraMemory() {
        Stack<Node> nodeStack = new Stack<>();
        Set<Node> visited = new HashSet<>();  // Just a regular HashSet is fine (vs. LinkedHashSet, TreeSet).
        List<Integer> traversal = new ArrayList<>();

        if (root == null) return traversal;
        nodeStack.push(root);
        while (true) {
            if (nodeStack.peek().left != null && !visited.contains(nodeStack.peek().left)) {
                visited.add(nodeStack.peek().left);
                nodeStack.push(nodeStack.peek().left);
                continue;
            }
            if (nodeStack.peek().right != null && !visited.contains(nodeStack.peek().right)) {
                visited.add(nodeStack.peek().right);
                nodeStack.push(nodeStack.peek().right);
                continue;
            }
            traversal.add(nodeStack.pop().data);

            if (nodeStack.isEmpty()) return traversal;
        }
    }

    /*
     * This implementation uses a single stack to hold state similar to the recursion stack.
     * Then the tree root is changed in each pass of the algorithm and the postorder traversal
     * essentially operates on subtrees until it needs to backtrack.
     * It kind of reminds me of a DFS.
     *
     * I prefer the two data structures approach TBH. It is cleaner and easier to understand.
     * The extra memory may be an issue on constrained devices or very large data sets, but that is
     * rare compared to the typical case.
     */
    public List<Integer> postOrderTraversalHelper_Iterative_NoExtraMemory() {
        Stack<Node> nodeStack = new Stack<>();
        List<Integer> traversal = new ArrayList<>();

        if (root == null) return traversal;
        Node newRoot = root;
        while (true) {
            while (newRoot != null) {
                nodeStack.push(newRoot);
                if (newRoot.right != null) nodeStack.push(newRoot.right);
                newRoot = newRoot.left;
            }
            Node current = nodeStack.pop();
            // TODO: Checking the traversal data in this if statement is incorrect. The data may be duplicated.
            // The proper answer there is to store the node refs in the traversal and not their data.
            if (!nodeStack.isEmpty() &&
                    nodeStack.peek().right == current &&
                    (current.left != null || current.right != null) &&
                    traversal.get(traversal.size()-1) != current.right.data) {
                newRoot = current;
                continue;
            }
            traversal.add(current.data);

            if (nodeStack.isEmpty()) return traversal;
        }
    }

    public List<Integer> preOrderTraversal_Iterative() {
        Stack<Node> nodeStack = new Stack<>();
        List<Integer> traversal = new ArrayList<>();

        if (root == null) return traversal;
        nodeStack.push(root);
        while(!nodeStack.isEmpty()) {
            Node current = nodeStack.pop();
            if (current.right != null)
                nodeStack.push(current.right);
            if (current.left != null)
                nodeStack.push(current.left);
            traversal.add(current.data);
        }

        return traversal;
    }
}
