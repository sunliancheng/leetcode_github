package LC0_200.LC100_150;

import org.junit.Test;

public class LC115_Distinct_Subsequences {

    @Test
    public void test() {
        System.out.println(numDistinct("rabbbit", "rabbit"));
    }

    public int numDistinct(String s, String t) {
        boolean flag = true;
        int[] dp1 = new int[s.length()];
        int[] dp2 = new int[s.length()];
        for (int i = t.length() - 1; i >= 0; --i) {
            for (int j = s.length() - 1; j >= 0; --j) {
                if (t.charAt(i) == s.charAt(j)) {
                    if (flag)
                        dp1[j] = 1 + findSmall(dp2, j);
                    else
                        dp1[j] = findSmall(dp2, j);
                }
            }
            flag = false;
            int[] tem = dp1;
            dp2 = dp1;
            dp1 = new int[s.length()];
        }
        return findSmall(dp2, 0);
    }

    public int findSmall(int[] dp, int idx) {
        int temp = 0;
        for (int i = dp.length - 1; i >= idx; --i) {
            if (dp[i] != 0) {
                temp += dp[i];
            }
        }
        return temp;
    }

}
