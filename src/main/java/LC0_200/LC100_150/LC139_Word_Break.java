package LC0_200.LC100_150;

import java.util.HashSet;
import java.util.List;

public class LC139_Word_Break {
    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); ++i) {
            for (String str : wordDict) {
                if (i >= str.length() && str.equals(s.substring(i - str.length(), i)))
                    dp[i] = dp[i - str.length()] || dp[i];
            }
        }
        return dp[s.length()];
    }
}
