package LeetCodeUtils.Contest.C2021_04_11;

import org.junit.Test;

public class Third {

    @Test
    public void test() {
        System.out.println(minSideJumps(new int[]{0,1,2,3,0}));
        //System.out.println(minSideJumps(new int[]{0,1,1,3,3,0}));
        //System.out.println(minSideJumps(new int[]{0,2,1,0,3,0}));
    }


    int INF = Integer.MAX_VALUE / 2;
    public int minSideJumps(int[] obstacles) {
        int[][] dp = new int[obstacles.length][3];
        dp[0][0] = dp[0][2] = 1; dp[0][1] = 0;
        int n = obstacles.length - 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < 3; ++j) {
                dp[i][j] = INF;
                if (obstacles[i] == j + 1) continue;
                for (int k = 0; k < 3; ++k) {
                    if (obstacles[i] == k + 1) continue;
                    int cost = 0;
                    if (k != j) cost = 1;
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + cost);
                }
            }
        }
        return Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
    }



}
