package LC0_200.LC150_200;

import java.util.Arrays;

public class LC164_Maximum_Gap {

    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            int gap = nums[i + 1] - nums[i];
            max = max > gap ? max : gap;
        }
        return max;
    }

}
