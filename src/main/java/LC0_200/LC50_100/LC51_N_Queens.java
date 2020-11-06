package LC0_200.LC50_100;

import LeetCodeUtils.MyPrint;

import org.junit.Test;

import java.util.*;

/**
 * 2020-09-25 11:24 PM at Hangzhou
 */
public class LC51_N_Queens {

    Set<String> set = new HashSet<>();
    List<List<String>> res = new ArrayList<>();
    List<String> te = new ArrayList<>();
    char[][] dp;

    public List<List<String>> solveNQueens(int n) {
        //dp = new char[n][n];
        for (int i = 0; i < n; ++i) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; ++j)
                sb.append('.');
            te.add(sb.toString());
        }
        recursive(0, n);
        return res;
    }


    public void recursive(int i, int n) {
        if (i == n) {
            List<String> t = new ArrayList<>(te);
            res.add(t);
            return;
        }

        for (int j = 0; j < n; ++j) {
            StringBuilder row = new StringBuilder();
            StringBuilder col = new StringBuilder();
            StringBuilder dig = new StringBuilder();
            StringBuilder dig2 = new StringBuilder();
            row.append(i); row.append('-');
            col.append(j); col.append('|');
            int tem = i + j;
            dig.append(tem); dig.append('[');
            int temp = i - j;
            dig2.append(temp); dig2.append(']');
            if (!set.contains(row.toString()) && !set.contains(col.toString())
                    && !set.contains(dig.toString()) && !set.contains(dig2.toString())) {
                set.add(row.toString()); set.add(col.toString());
                set.add(dig.toString()); set.add(dig2.toString());

                //dp[i][j] = 'Q';
                String s = te.get(i);
                StringBuilder sb = new StringBuilder();
                for (int l = 0; l < s.length(); ++l) {
                    if (l == j) {
                        sb.append('Q');
                        continue;
                    }
                    sb.append(s.charAt(l));
                }
                te.set(i, sb.toString());

                // recursive
                int ii = i + 1;
                //System.out.println(te);
                recursive(ii, n);

                set.remove(row.toString()); set.remove(col.toString());
                set.remove(dig2.toString()); set.remove(dig.toString());
                //dp[i][j] = '.';
                s = te.get(i);
                sb = new StringBuilder();
                for (int l = 0; l < s.length(); ++l) {
                    if (l == j) {
                        sb.append('.');
                        continue;
                    }
                    sb.append(s.charAt(l));
                }
                te.set(i, sb.toString());
            }
        }

    }


    @Test
    public void test() {
        System.out.println(solveNQueens(1));
    }


}
