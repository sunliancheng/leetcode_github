package LC0_200.LC50_100;

public class LC97_Interleaving_String {
    public boolean isInterleave(String s1, String s2, String s3) {if (s1.length() + s2.length() != s3.length())
        return false;

        boolean[] dp = new boolean[s2.length() + 1];
        dp[0] = true;

        for (int i = 0; i <= s1.length(); ++i) {
            for (int j = 0; j <= s2.length(); ++j) {
                int p = i + j - 1;
                if (i > 0 && s1.charAt(i - 1) != s3.charAt(p)) {
                    dp[j] = false;
                }
                if (j > 0 && s2.charAt(j - 1) == s3.charAt(p))
                    dp[j] |= dp[j - 1];
            }
        }
        return dp[s2.length()];
    }
}
