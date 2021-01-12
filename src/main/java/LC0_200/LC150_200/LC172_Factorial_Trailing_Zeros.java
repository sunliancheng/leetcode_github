package LC0_200.LC150_200;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class LC172_Factorial_Trailing_Zeros {

    public int trailingZeroes(int n) {
        int sol = 0;
        int expOfFive = 5;
        while(n >= expOfFive){
            sol += n / expOfFive;
            expOfFive *= 5;
        }
        return sol;
    }

    @Test
    public void test() {
        int[][] intervals = new int[][]{{1, 3}, {2, 3}, {0, 1}, {1, 2}};
        Collections.sort(Arrays.asList(intervals), (a, b) -> a[0] < b[0] ? -1 : a[0] == b[0] ? a[1] - b[1] : 1);
        for (int[] in : intervals)
            System.out.println(in[0] + " " + in[1]);
    }

}
