package LeetCodeUtils;

import java.util.LinkedList;
import java.util.List;

public class MyPrint {

    /**
     *
     * @param root
     */
    public static void printTreeInLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("The tree is null, return...");
            return;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.addLast(root);
        while (list.size() != 0) {
            int size = list.size();
            while (--size >= 0) {
                TreeNode tem = list.removeFirst();
                if(tem.left != null) list.addLast(tem.left);
                if(tem.right != null) list.addLast(tem.right);
                System.out.print(tem.val + " ");
            }
            System.out.println();
        }

    }

    /**
     *  print the 2D boolean matrix
     * @param matrix
     */
    public static void print2DMatrix(boolean[][] matrix) {
        System.out.println("*********printing the 2D boolean matrix********");
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }

    /**
     *  print the 2D int matrix
     * @param matrix
     */
    public static void print2DMatrix(int[][] matrix) {
        System.out.println("*********printing the 2D int matrix********");
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }

    /**
     *  print the 1D boolean matrix
     * @param matrix
     */
    public static void print1DMatrix(boolean[] matrix) {
        System.out.println("*********printing the 1D boolean matrix********");
        for (int i = 0; i < matrix.length; ++i) {
            System.out.print(matrix[i] + " ");
        }
        System.out.println();
    }

    /**
     *  print the 1D int matrix
     * @param matrix
     */
    public static void print1DMatrix(int[] matrix) {
        System.out.println("*********printing the 1D int matrix********");
        for (int i = 0; i < matrix.length; ++i) {
            System.out.print(matrix[i] + " ");
        }
        System.out.println();
    }


    public static void print2DMatrix(char[][] matrix) {
        System.out.println("*********printing the 2D char matrix********");
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }
}
