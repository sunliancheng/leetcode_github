package LC200_400.LC200_250;

import org.junit.Test;

public class LC209_Minimum_Size_Subarray_Sum {

    @Test
    public void test() {

    }

    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            int tem_sum = 0;
            for (int j = i; j < nums.length; ++j) {
                int offSet = 1 + j - i;
                tem_sum += nums[j];
                if (tem_sum >= target) {
                    result = result < offSet ? result : offSet;
                    break;
                }
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

}
