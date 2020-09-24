package LC0_200.LC50_100;

import LeetCodeUtils.MyPrint;
import org.junit.Test;

/**
 *  dont care the time cost, aha
 *
 */
public class LC55_Jump_Game {

    public boolean canJump(int[] nums) {
        if (nums.length == 1)
            return true;
        if (nums[0] >= nums.length)
            return true;
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; --i) {
            int result = Integer.MAX_VALUE;
            int len = nums[i];
            for (int j = 1; j <= len && i + j < nums.length; ++j) {
                int temp = dp[j + i] + 1 > 0 ? dp[j + i] + 1 : dp[j + i];
                result = result < temp ? result : temp;
            }
            dp[i] = result;
        }
        return dp[0] == Integer.MAX_VALUE ? false : true;
    }

    @Test
    public void test() {
        System.out.println(canJump(new int[]{0}));
    }

    /**
     * Given an array of non-negative integers, you are initially positioned at the first index of the array.
     *
     * Each element in the array represents your maximum jump length at that position.
     *
     * Determine if you are able to reach the last index.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [2,3,1,1,4]
     * Output: true
     * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
     * Example 2:
     *
     * Input: nums = [3,2,1,0,4]
     * Output: false
     * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
     */
}
