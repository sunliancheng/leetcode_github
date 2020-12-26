package LC400_600.LC550_600;

import org.junit.Test;

public class LC566_Reshape_The_Matrix {

    @Test
    public void test() {
        matrixReshape(new int[][]{{1,2},{3,4}},1, 4);
    }

    public int[][] matrixReshape(int[][] nums, int r, int c) {

        if (nums.length == 0 || nums[0].length == 0 || r * c != nums.length * nums[0].length)
            return nums;
        int[][] res = new int[r][c];
        r = c = 0;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < nums[0].length; ++j) {
                res[r][c++] = nums[i][j];
                if (c == res[0].length) {
                    c = 0; ++r;
                }
            }
        }
        return res;

    }

}
