package LC0_200.LC150_200;

public class LC198_House_Robber {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int[] dp = new int[nums.length + 1];
        dp[0] = 0; dp[1] = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            dp[i + 1] = Math.max(dp[i - 1] + nums[i], dp[i]);
        }
        return dp[nums.length];
    }
}
