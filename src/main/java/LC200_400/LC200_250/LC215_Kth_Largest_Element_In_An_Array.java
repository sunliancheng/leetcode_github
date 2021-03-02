package LC200_400.LC200_250;

import java.util.Arrays;
import java.util.Comparator;

public class LC215_Kth_Largest_Element_In_An_Array {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

}
