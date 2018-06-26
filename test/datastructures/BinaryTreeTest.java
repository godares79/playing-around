package datastructures;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class BinaryTreeTest {

    private static BinaryTree testTree = null;

    @BeforeEach
    static void buildTestTree() {
        // 1 -> 2,3 -> 4,5,-,-
        testTree = new BinaryTree(1);
        testTree.root.left = new BinaryTree.Node(2);
        testTree.root.left.left = new BinaryTree.Node(4);
        testTree.root.left.right = new BinaryTree.Node(5);
        testTree.root.right = new BinaryTree.Node(3);
    }

    @Test
    void inOrderTraversal() {
        List<Integer> traversal = testTree.inOrderTraversal();
        assertThat(traversal, is(Arrays.asList(4,2,5,1,3)));
    }

    @Test
    void inOrderTraversal_Iterative() {
        testTree.root.right.left = new BinaryTree.Node(6);
        testTree.root.right.right = new BinaryTree.Node(7);
        testTree.root.left.right.left = new BinaryTree.Node(8);
        List<Integer> traversal = testTree.inOrderTraversal_Iterative();
        assertThat(traversal, is(Arrays.asList(4,2,8,5,1,6,3,7)));
    }

    @Test
    void postOrderTraversal() {
        List<Integer> traversal = testTree.postOrderTraversal();
        assertThat(traversal, is(Arrays.asList(4,5,2,3,1)));
    }

    @Test
    void postOrderTraversal_Iterative_ExtraMemory() {
        List<Integer> traversal = testTree.postOrderTraversalHelper_Iterative_ExtraMemory();
        assertThat(traversal, is(Arrays.asList(4,5,2,3,1)));
    }

    @Test
    void postOrderTraversal_Iterative_NoExtraMemory() {
        testTree.root.right.left = new BinaryTree.Node(6);
        testTree.root.right.right = new BinaryTree.Node(7);
        List<Integer> traversal = testTree.postOrderTraversalHelper_Iterative_NoExtraMemory();
        assertThat(traversal, is(Arrays.asList(4,5,2,6,7,3,1)));
    }

    @Test
    void preOrderTraversal() {
        List<Integer> traversal = testTree.preOrderTraversal();
        assertThat(traversal, is(Arrays.asList(1,2,4,5,3)));
    }

    @Test
    void preOrderTraversal_Iterative() {
        List<Integer> traversal = testTree.preOrderTraversal_Iterative();
        assertThat(traversal, is(Arrays.asList(1,2,4,5,3)));

        testTree.root.right.left = new BinaryTree.Node(6);
        testTree.root.right.right = new BinaryTree.Node(7);
        traversal = testTree.preOrderTraversal_Iterative();
        assertThat(traversal, is(Arrays.asList(1,2,4,5,3,6,7)));
    }
}