package LC200_400.LC350_400;

import org.junit.Test;

public class LC357_Count_Numbers_With_Unique_Digits {

    @Test
    public void test() {
        System.out.println(countNumbersWithUniqueDigits(10));
    }

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;
        int[] dp = new int[n + 1];
        dp[1] = 9;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] * (11- i);
        }
        int ans = 1;
        for (int i = 1; i <= n; i++)
            ans += dp[i];
        return ans;
    }

}
