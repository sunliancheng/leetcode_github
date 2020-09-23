package LC0_200.LC50_100;

import LeetCodeUtils.MyMatrix;
import LeetCodeUtils.MyPrint;
import org.junit.Test;

/**
 *  2020-09-23 10:28 PM at Hangzhou
 */
public class LC62_Unique_Paths {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 1; i < (m > n ? m : n); ++i) {
            for (int x = 0; x <= (i); ++x) {
                if (x == i || x == m - 1) {
                    int temp = calculateDistance(x, i, dp);
                    if (temp != Integer.MAX_VALUE)
                        dp[x][i] = temp;
                    break;
                } else if (x == i || x == n - 1) {
                    int temp = calculateDistance(i, x, dp);
                    if (temp != Integer.MAX_VALUE)
                        dp[i][x] = temp;
                }
                int temp = calculateDistance(x, i, dp);
                if (temp != Integer.MAX_VALUE)
                    dp[x][i] = temp;
                temp = calculateDistance(i, x, dp);
                if (temp != Integer.MAX_VALUE)
                    dp[i][x] = temp;
            }
        }
        return dp[m - 1][n - 1];
    }


    public int calculateDistance(int i, int j, int[][]dp) {
        if (i >= dp.length || i < 0)
            return Integer.MAX_VALUE;
        if (j >= dp[0].length || j < 0)
            return Integer.MAX_VALUE;
        if (j == 0)
            return dp[i - 1][j];
        else if (i == 0)
            return dp[i][j - 1];
        else
            return dp[i][j - 1] + dp[i - 1][j];
    }

    @Test
    public void test() {
        System.out.println(uniquePaths(3, 2));
    }
}
