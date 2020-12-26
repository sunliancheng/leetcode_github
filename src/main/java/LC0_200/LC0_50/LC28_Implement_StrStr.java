package LC0_200.LC0_50;

import LeetCodeUtils.MyPrint;
import org.junit.Test;

import java.util.Arrays;

public class LC28_Implement_StrStr {

    @Test
    public void test() {
        System.out.println(strStr("helllo", "ll0"));
    }


    int[] next;
    public int strStr(String haystack, String needle) {
        int k = -1, n = haystack.length(), p = needle.length();
        if (p == 0) return 0;
        next = new int[p];
        Arrays.fill(next, -1);
        calNext(needle);

        for (int i = 0; i < n; ++i) {
            while (k > -1 && needle.charAt(k + 1) != haystack.charAt(i))
                k = next[k];
            if (needle.charAt(k + 1) == haystack.charAt(i))
                ++k;
            if (k == p - 1)
                return i - p + 1;
        }
        return -1;
    }

    public void calNext(String needle) {
        MyPrint.print1DMatrix(next);
        for (int j = 1, p = -1; j < needle.length(); ++j) {
            while (p > -1 && needle.charAt(p + 1) != needle.charAt(j))
                p = next[p];
            if (needle.charAt(p + 1) == needle.charAt(j))
                ++p;
            next[j] = p;
        }
        MyPrint.print1DMatrix(next);
    }
}
