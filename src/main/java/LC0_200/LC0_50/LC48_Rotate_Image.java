package LC0_200.LC0_50;

import java.util.Stack;

public class LC48_Rotate_Image {
    public void rotate(int[][] matrix) {

        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix.length; ++j) {
                stack.push(matrix[i][j]);
            }
        }

        for (int j = 0; j < matrix.length; ++j) {
            for (int i = matrix.length - 1; i >= 0; --i) {
                matrix[i][j] = stack.pop();
            }
        }
    }
}
