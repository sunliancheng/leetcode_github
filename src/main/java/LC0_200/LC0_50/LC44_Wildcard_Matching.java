package LC0_200.LC0_50;

import org.junit.Test;

public class LC44_Wildcard_Matching {

    public boolean isMatch(String s, String p) {

        if (s == null || p == null)
            return false;

        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;

        // 2. dp[0][i] = false
        // 3. dp[j][0]
        for (int j = 1; j < p.length() + 1; ++j)
            if (p.charAt(j - 1) == '*')
                dp[j][0] = dp[j - 1][0];

        for (int i = 1; i < s.length() + 1; ++i)
            for (int j = 1; j < p.length() + 1; ++j) {
                char cs = s.charAt(i - 1);
                char cp = p.charAt(j - 1);
                if (cs == cp || cp == '?')
                    dp[j][i] = dp[j - 1][i - 1];
                else if (cp == '*')
                    dp[j][i] = dp[j - 1][i] || dp[j][i - 1];
            }

        return dp[p.length()][s.length()];
    }

    @Test
    public void test() {
        System.out.println(isMatch("ss", "*"));
    }

}
