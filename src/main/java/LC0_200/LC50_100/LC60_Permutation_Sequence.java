package LC0_200.LC50_100;

public class LC60_Permutation_Sequence {

    public String getPermutation(int n, int k) {

        return "";
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
