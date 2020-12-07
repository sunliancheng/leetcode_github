package LC200_400.LC250_300;

public class LC279_Perfect_Squares {
    public int numSquares(int n) {
        if(n < 4)
            return n;
        int dp[] = new int[n + 1];

        for(int i = 1; i <= n; ++i) {
            //都由 1 组成
            dp[i] = i;

            for(int j = 1; j * j <= i; ++j)
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
        }
        return dp[n];
    }
}
