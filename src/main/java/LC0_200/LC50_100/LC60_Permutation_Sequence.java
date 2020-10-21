package LC0_200.LC50_100;

import org.junit.Test;

public class LC60_Permutation_Sequence {

    @Test
    public void tes() {
        getPermutation(3, 3);
    }


    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = 1 + i;
        }
        for (int i = 1; i < k; ++i)
            nextPermutation(nums);
        StringBuilder sb = new StringBuilder();
        for (int i : nums)
            sb.append(i);

        return sb.toString();
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i])
            --i;
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i])
                --j;
            swap(nums, i , j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            ++i; --j;
        }
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
