package LC0_200.LC150_200;

public class LC152_Maximum_Product_Subarray {
    public int maxProduct(int[] nums) {
        if (nums.length == 0 || nums == null)
            return -1;
        int final_result = nums[0], cur_max = nums[0], cur_min = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            int temp = cur_max;
            temp = Math.max(nums[i], Math.max(nums[i] * cur_max, nums[i] * cur_min));
            cur_min = Math.min(nums[i], Math.min(nums[i] * cur_max, nums[i] * cur_min));
            cur_max = temp;

            if (cur_max > final_result) {
                final_result = cur_max;
            }
        }

        return final_result;
    }
}
