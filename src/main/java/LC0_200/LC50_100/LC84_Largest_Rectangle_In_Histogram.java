package LC0_200.LC50_100;

import LeetCodeUtils.MyMatrix;
import org.junit.Test;

public class LC84_Largest_Rectangle_In_Histogram {

    @Test
    public void test() {
        System.out.println(largestRectangleArea(MyMatrix.OneDIntMatrixAdapter("[1]")));
    }

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0)
            return 0;
        if (heights.length == 1)
            return heights[0];
        int max = 0;

        for (int i = 0; i < heights.length; ++i) {
            int k = 1, h = heights[i];
            while (k <= i) {
                h = Math.min(h, heights[i - k]);
                max = Math.max(max, h * (k + 1));
                k++;
            }
        }
        return max;
    }

}
