package LC600_800.LC600_650;

public class LC647_Palindromic_Substrings {


    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); ++i) {
            res += extendSubstrings(s, i, i);
            res += extendSubstrings(s, i, i + 1);
        }
        return res;
    }

    int extendSubstrings(String s, int l, int r) {
        int count = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            --l; ++r;
            ++count;
        }
        return count;
    }

}
