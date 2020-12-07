package LC0_200.LC50_100;

import org.junit.Test;

public class LC76_Minimum_Window_Substring {

    @Test
    public void test() {
        System.out.println('z' - 'A');
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }


    public String minWindow(String s, String t) {

        int l = 0, r = 0;
        int[] chars = new int[60];
        boolean[] flag = new boolean[60];
        for (int i = 0; i < t.length(); ++i) {
            int dx = t.charAt(i) - 'A';
            chars[dx]++;
            flag[dx] = true;
        }
        int count = 0; int min_l = 0, min_size = s.length() + 1;
        for (; r < s.length(); ++r) {
            int dx = s.charAt(r) - 'A';
            if (flag[dx]) {
                if (--chars[dx] >= 0)
                    ++count;
                while (count == t.length()) {
                    int d = s.charAt(l) - 'A';
                    if (r - l + 1 < min_size) {
                        min_l = l;
                        min_size = r - l + 1;
                    }
                    if (flag[d] && ++chars[d] > 0)
                        --count;
                    ++l;
                }
            }
        }
        return min_size > s.length() ? "" : s.substring(min_l, min_size + min_l);
    }

}
