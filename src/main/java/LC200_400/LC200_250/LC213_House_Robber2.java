package LC200_400.LC200_250;

public class LC213_House_Robber2 {

    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int[] dp = new int[nums.length + 1];
        int result = 0; dp[0] = 0;
        // 使用第一个
        dp[1] = nums[0];
        for (int i = 1; i < nums.length; ++i) {

            if (i == nums.length - 1) {
                dp[i + 1] = dp[i];
                break;
            }
            dp[i + 1] = Math.max(dp[i - 1] + nums[i], dp[i]);
        }

        result = dp[nums.length];

        // 不使用第一个
        dp[1] = 0;
        for (int i = 1; i < nums.length; ++i)
            dp[i + 1] = Math.max(dp[i - 1] + nums[i], dp[i]);

        result = dp[nums.length] > result ? dp[nums.length] : result;
        return result;
    }

}
