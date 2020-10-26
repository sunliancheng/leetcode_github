package LC0_200.LC50_100;

public class LC53_Maximum_Subarray {

    public int maxSubArray(int[] nums) {

        int maxCurrent = nums[0];
        int dp = nums[0];

        for(int i = 1; i < nums.length; ++i) {
            maxCurrent = nums[i] + (maxCurrent > 0 ? maxCurrent : 0);
            dp = (dp > maxCurrent ? dp : maxCurrent);
        }
        return dp;

    }

}
