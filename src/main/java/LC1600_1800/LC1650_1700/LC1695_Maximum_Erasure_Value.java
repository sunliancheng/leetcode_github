package LC1600_1800.LC1650_1700;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class LC1695_Maximum_Erasure_Value {

    @Test
    public void test() {
        System.out.println(maximumUniqueSubarray(new int[]{5,2,1,2,5,2,1,2,5}));
    }

    /**
     * You are given an array of positive integers nums and want to erase a subarray containing unique elements.
     * The score you get by erasing the subarray is equal to the sum of its elements.
     * Return the maximum score you can get by erasing exactly one subarray.
     * An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is,
     * if it is equal to a[l],a[l+1],...,a[r] for some (l,r).
     *
     * Input: nums = [4,2,4,5,6]   Output: 17
     * Explanation: The optimal subarray here is [2,4,5,6].
     *
     * Input: nums = [5,2,1,2,5,2,1,2,5]   Output: 8
     * Explanation: The optimal subarray here is [5,2,1] or [1,2,5].
     */
    public int maximumUniqueSubarray(int[] nums) {
        if (nums.length == 1) return nums[0];

        int max = nums[0], result = 0;
        Set<Integer> set = new HashSet<>();
        set.add(nums[0]);

        int l = 0, r = 1;
        while (l <= r && r < nums.length) {
            if (set.add(nums[r])) {
                // does not exist
                max += nums[r];
                ++r;
            } else {
                // does exist
                set.remove(nums[l]);
                max -= nums[l];
                ++l;
            }
            result = result > max ? result : max;
        }

        return result;
    }

}
