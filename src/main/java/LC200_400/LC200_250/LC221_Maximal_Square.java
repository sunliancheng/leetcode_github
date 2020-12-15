package LC200_400.LC200_250;

import org.junit.Test;

public class LC221_Maximal_Square {

    @Test
    public void test() {

    }


    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int m = matrix.length, n = matrix[0].length, max_side = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i)
            for (int j = 1; j <= n; ++j) {
                if (matrix[i - 1][j - 1] == '1')
                    dp[i][j] = Math.min(dp[i - 1][j - 1],
                            Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                max_side = max_side > dp[i][j] ? max_side : dp[i][j];
            }
        return max_side * max_side;
    }

}
