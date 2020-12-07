package LC400_600.LC400_450;

import LeetCodeUtils.MyMatrix;
import org.junit.Test;

import java.util.Arrays;

public class LC435_Non_overlapping_Intervals {

    @Test
    public void test() {
        System.out.println(eraseOverlapIntervals(new int[][]{{1,2}, {2,4},{1,3}}));;
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0)
            return 0;
        Arrays.sort(intervals, (int[] o1, int[] o2) -> { return o1[1] - o2[1]; });

        int tail = intervals[0][1], ans = 0;
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] < tail) {
                ans++;
                continue;
            } else {
                tail = intervals[i][1];
            }
        }
        return ans;
    }

}
