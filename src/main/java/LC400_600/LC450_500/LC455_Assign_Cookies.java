package LC400_600.LC450_500;

import LeetCodeUtils.MyMatrix;
import org.junit.Test;

import java.util.Arrays;

public class LC455_Assign_Cookies {

    @Test
    public void test() {
        System.out.println(findContentChildren(MyMatrix.OneDIntMatrixAdapter("[1,2]"),
                MyMatrix.OneDIntMatrixAdapter("[3,2,1]")));
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j])
                ++i;
            ++j;
        }
        return i;
    }

}
