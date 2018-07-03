package datastructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreePrettyPrinterTest {

    @Test
    void printTree() {
        BinaryTree testTree = new BinaryTree(1);
        testTree.root.left = new BinaryTree.Node(2);
        testTree.root.left.left = new BinaryTree.Node(4);
        testTree.root.left.right = new BinaryTree.Node(5);
        testTree.root.right = new BinaryTree.Node(3);

        TreePrettyPrinter.printTree(testTree);
    }
}