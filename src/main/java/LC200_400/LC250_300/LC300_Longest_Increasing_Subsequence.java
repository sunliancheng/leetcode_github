package LC200_400.LC250_300;

public class LC300_Longest_Increasing_Subsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1];
        dp[1] = 1; int tempMax = 0;
        int result = 0;
        for(int i = 1; i <= nums.length; ++i){
            tempMax = 0; //record the max{dp[j]}
            for(int j = 1; j <= nums.length; ++j)
                if(nums[i-1] > nums[j-1])
                    tempMax = Math.max(tempMax, dp[j]);
            dp[i] = tempMax + 1;
            result = Math.max(dp[i], result);
        }
        return result;
    }
}
