package LC600_800.LC650_700;

import LeetCodeUtils.MyMatrix;
import org.junit.Test;

public class LC665_Non_Decreasing_Array {

    @Test
    public void test() {
        System.out.println(checkPossibility(MyMatrix.OneDIntMatrixAdapter("[1,4,1,2]")));
    }

    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; ++i)
            if (nums[i - 1] > nums[i]) {
                count++;
                if (count > 1)
                    return false;
                if (i < 2 || nums[i - 2] <= nums[i])
                    nums[i - 1] = nums[i];
                else
                    nums[i] = nums[i - 1];
            }
        return true;
    }

    /**
     * Given an array nums with n integers,
     * your task is to check if it could become non-decreasing by modifying at most 1 element.
     *
     * 124 3 333
     * 159 3 555
     *
     * We define an array is non-decreasing
     * if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).
     */

}
