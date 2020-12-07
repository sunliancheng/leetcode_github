package LC400_600.LC400_450;

public class LC416_Partition_Equal_Subset_Sum {
    public boolean canPartition(int[] nums) {

        //one part is equal to another
        //pick up elements to let sum of them is half of the sum of all
        int sum = 0;
        for(int i : nums)
            sum += i;
        if(sum % 2 == 1)
            return false;
        sum /= 2;
        int[][] dp = new int[nums.length + 1][sum + 1];
        for(int i = 1; i <= nums.length; ++i) {
            for(int j = 1; j <= sum; ++j) {
                if(nums[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j - nums[i - 1]] + nums[i - 1], dp[i - 1][j]);
            }
        }
        if(dp[nums.length][sum] == sum)
            return true;
        return false;
    }
}
