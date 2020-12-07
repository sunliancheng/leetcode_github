package LC0_200.LC100_150;

import java.util.HashSet;
import java.util.List;

public class LC139_Word_Break {
    public boolean wordBreak(String s, List<String> wordDict) {

        HashSet<String> set = new HashSet<>();
        set.addAll(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for(int i = 1; i < s.length() + 1; ++i){
            for(int j = i - 1; j >= 0; --j){
                if(set.contains(s.substring(j, i))){
                    dp[i] = dp[j];
                    if(dp[i]) break;
                }
            }
        }
        return dp[s.length()];
    }
}
