package LC400_600.LC400_450;

import java.util.Arrays;

public class LC421_Maximum_XOR_Of_Two_Numbers_In_An_Array {
    public int findMaximumXOR(int[] nums) {
        Arrays.sort(nums);
        int or = 0;
        for (int n : nums)
            or |= n;

        int max = 0;
        int i = 0, j = nums.length - 1;
        while (i < j) {
            max = Math.max(max, nums[i] ^ nums[j]);
            if ((or ^ nums[i]) > nums[j])
                i++;
            else j--;
        }
        return max;
    }
}
