package datastructures;

/**
 * Utility class. One public static method, print the given tree in a nicely readable manner.
 * Should have different overrides given the different types of trees I want to work with.
 */
public class TreePrettyPrinter {
    public static void printTree(BinaryTree tree) {
        // Get the height of the tree, that tells us how to indent.
        // Get the maximum length of the integer data, that tells us how to indent.
        // Both those together should make it possible to push a nice looking binary tree.
        int treeHeight = tree.treeHeight();
        int dataMaxLength = tree.getLargestLengthData();

        // Fill an array with the contents in a formatted way.
        int rows = treeHeight;
        int cols = (int) ((Math.pow(2,treeHeight-1)*2) + ((dataMaxLength+2)*Math.pow(2,treeHeight-2)) + (4*(Math.pow(2,treeHeight-2)-1)));
        System.out.format("RowsXCols = %d x %d\n", rows, cols);

        int[][] printContents = new int[rows * rows - 1 /* allocate extra space for the edges */][cols];
        int rowNumber = 0;
        for (int i = 0; i < printContents.length; i++) {
            if (i%2 == 0) {
                // Have a node row


            } else {
                // Have a edge row
            }
        }
    }
}
