package LC600_800.LC650_700;

public class LC696_Count_Binary_Substrings {

    public int countBinarySubstrings(String s) {
        int pre = 0, cur = 1, count = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cur++;
            } else {
                pre = cur;
                cur = 1;
            }
            if (pre >= cur) {
                ++count;
            }
        }
        return count;
    }

}
