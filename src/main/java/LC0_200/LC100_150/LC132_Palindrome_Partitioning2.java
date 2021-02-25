package LC0_200.LC100_150;

import org.junit.Test;

public class LC132_Palindrome_Partitioning2 {

    @Test
    public void test() {
        int r = minCut("apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp");
        System.out.println(r);
    }

    public int minCut(String s) {
        int n = s.length();
        int cuts[] = new int[n];
        boolean isPalindrome[][] = new boolean[n][n];
        for(int i = 0; i < n; i++){
            int minCuts = Integer.MAX_VALUE;
            for(int j = i;j >= 0; j--){
                if(s.charAt(i) == s.charAt(j) && (j + 1 >= i - 1 || isPalindrome[j + 1][i - 1])){
                    isPalindrome[j][i] = true;
                    minCuts = Math.min(minCuts, j - 1 < 0 ? 0 : cuts[j - 1] + 1);
                }
            }
            cuts[i] = minCuts;
        }
        return cuts[n-1];
    }



}
