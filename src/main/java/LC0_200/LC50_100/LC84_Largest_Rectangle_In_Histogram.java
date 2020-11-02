package LC0_200.LC50_100;

import LeetCodeUtils.MyMatrix;
import org.junit.Test;

public class LC84_Largest_Rectangle_In_Histogram {

    @Test
    public void test() {
        System.out.println(largestRectangleArea(MyMatrix.OneDIntMatrixAdapter("[0,9]")));
    }

    public int largestRectangleArea(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; ++i) {
            int k = 0, h = heights[i];
            while (k <= i) {
                h = h < heights[i - k] ? h : heights[i - k];
                max = max > h * (k + 1) ? max : h * (k + 1);
                k++;
            }
        }
        return max;
    }

}
