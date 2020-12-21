package LC200_400.LC300_350;

import LeetCodeUtils.MyMatrix;
import LeetCodeUtils.MyPrint;
import org.junit.Test;

public class LC304_Range_Sum_Query2D_Immutable {

    @Test
    public void test() {
        NumMatrix numMatrix = new
                NumMatrix(MyMatrix.IntMatrixAdapter(
                "[[3, 0, 1, 4, 2]," +
                "[5, 6, 3, 2, 1]," +
                "[1, 2, 0, 1, 5]," +
                "[4, 1, 0, 1, 7]," +
                "[1, 0, 3, 0, 5]]", 5, 5));
        System.out.println(numMatrix.sumRegion(2,1,4,3));
    }
}


class NumMatrix {

    private int[][] dp;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                dp[r + 1][c + 1] = dp[r + 1][c] + dp[r][c + 1] + matrix[r][c] - dp[r][c];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
    }
}