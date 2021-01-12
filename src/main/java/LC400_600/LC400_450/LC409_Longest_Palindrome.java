package LC400_600.LC400_450;

import org.junit.Test;

public class LC409_Longest_Palindrome {

    @Test
    public void test() {
        System.out.println(longestPalindrome("abccccdd"));
    }


    public int longestPalindrome(String s) {
        boolean flag = false;
        int res = 0;
        int[] chars = new int[58];
        for (int i = 0; i < s.length(); ++i) {
            int idx = s.charAt(i) - 'A';
            ++chars[idx];
        }

        for (int i : chars) {
            int tem = i / 2 * 2;
            res += tem;
            if (i != tem)
                flag = true;
        }

        if (flag)
            return 1 + res;
        return res;
    }

}
