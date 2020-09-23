package LC0_200.LC50_100;

import LeetCodeUtils.MyPrint;
import org.junit.Test;

/**
 *  2020-09-23 10:55 PM at Hangzhou
 */
public class LC64_Minimum_Path_Sum {

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < (m > n ? m : n); ++i) {
            for (int x = 0; x <= (i); ++x) {
                if (x == i || x == m - 1) {
                    int temp = calculateDistance(x, i, dp, grid);
                    if (temp != Integer.MAX_VALUE)
                        dp[x][i] = temp;
                    break;
                } else if (x == i || x == n - 1) {
                    int temp = calculateDistance(i, x, dp, grid);
                    if (temp != Integer.MAX_VALUE)
                        dp[i][x] = temp;
                }
                int temp = calculateDistance(x, i, dp, grid);
                if (temp != Integer.MAX_VALUE)
                    dp[x][i] = temp;
                temp = calculateDistance(i, x, dp, grid);
                if (temp != Integer.MAX_VALUE)
                    dp[i][x] = temp;
            }
        }
        return dp[m - 1][n - 1];
    }

    public int calculateDistance(int i, int j, int[][]dp, int grid[][]) {
        if (i >= dp.length || i < 0)
            return Integer.MAX_VALUE;
        if (j >= dp[0].length || j < 0)
            return Integer.MAX_VALUE;
        if (j == 0)
            return dp[i - 1][j] + grid[i][j];
        else if (i == 0)
            return dp[i][j - 1] + grid[i][j];
        else
            return Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
    }

    @Test
    public void test() {
        minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
    }
}
