package LC0_200.LC0_50;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class LC48_Rotate_Image {
    public void rotate(int[][] matrix) {
        int temp = 0, n = matrix.length - 1;
        for (int i = 0; i <= n / 2; ++i) {
            for (int j = i; j < n - i; ++j) {
                temp = matrix[j][n - 1];
                matrix[j][n - i] = matrix[i][j];
                matrix[i][j] = matrix[n - j][i];
                matrix[n - j][i] = matrix[n - i][n - j];
                matrix[n - i][n - j] = temp;
            }
        }
    }
}
