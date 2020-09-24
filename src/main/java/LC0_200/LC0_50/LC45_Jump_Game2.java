package LC0_200.LC0_50;

import org.junit.Test;

/**
 *  I dont know why my program is so slow and not encounters the Time Limit Exception
 *  It is too late, and I just go to bed
 *  2020-09-19 01:34 AM at Hangzhou
 */

public class LC45_Jump_Game2 {

    public int jump(int[] nums) {
        if (nums.length == 1)
            return 0;
        if (nums[0] >= nums.length)
            return 1;
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
        return dp[0];
    }

    @Test
    public void test() {
        System.out.println(jump(new int[]{2, 1}));
    }

}
