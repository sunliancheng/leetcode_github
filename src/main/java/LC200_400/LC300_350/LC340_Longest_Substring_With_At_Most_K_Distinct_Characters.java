package LC200_400.LC300_350;

import org.junit.Test;

public class LC340_Longest_Substring_With_At_Most_K_Distinct_Characters {

    @Test
    public void test() {
        System.out.println(function("aa", 1));
    }

    public int function(String s, int k) {
        int l = 0, r = 0, max = 0;
        int[] arr = new int[60];

        // include left side and exclude the right side
        while (r < s.length()) {
            if (k > 0) {
                int idx = s.charAt(r) - 'A';
                if (arr[idx] == 0)
                    --k;
                ++arr[idx];
                ++r;
            } else {
                int idx = s.charAt(l) - 'A';
                if (--arr[idx] == 0)
                    ++k;
                ++l;
            }
            max = max > (r - l + 1) ? max : (r - l + 1);
        }
        return max;
    }

}
