package LC0_200.LC0_50;


import org.junit.Test;

public class LC31_Next_Permutaion {

    @Test
    public void test() {
        nextPermutation(new int[]{1, 2, 3});
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
