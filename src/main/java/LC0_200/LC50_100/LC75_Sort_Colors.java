package LC0_200.LC50_100;

import org.junit.Test;

public class LC75_Sort_Colors {

    public void sortColors(int[] nums) {
        int count_0 = 0, count_1 = 0;
        for (int i : nums)
            if (i == 0)
                count_0++;
            else if (i == 1)
                count_1++;
        for (int i = 0; i < nums.length; ++i)
            if (i < count_0)
                nums[i] = 0;
            else if (i < count_0 + count_1)
                nums[i] = 1;
            else
                nums[i] = 2;

    }


    @Test
    public void test() {
        sortColors(new int[]{2, 0, 2, 1, 1, 0});
    }

    /**
     * Given an array nums with n objects colored red, white, or blue,
     * sort them in-place so that objects of the same color are adjacent,
     * with the colors in the order red, white, and blue.
     *
     * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
     *
     * Follow up:
     *
     * Could you solve this problem without using the library's sort function?
     * Could you come up with a one-pass algorithm using only O(1) constant space?
     *
     *
     * Example 1:
     *
     * Input: nums = [2,0,2,1,1,0]
     * Output: [0,0,1,1,2,2]
     * Example 2:
     *
     * Input: nums = [2,0,1]
     * Output: [0,1,2]
     * Example 3:
     *
     * Input: nums = [0]
     * Output: [0]
     * Example 4:
     *
     * Input: nums = [1]
     * Output: [1]
     */
}
