package LC400_600.LC550_600;

import org.junit.Test;

import java.util.Arrays;

public class LC581_Shortest_Unsorted_Continuous_Subarray {

    @Test
    public void test() {
        findUnsortedSubarray(new int[]{2, 1});
    }

    public int findUnsortedSubarray(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr);
        int left = -1, right = 0;
        boolean flag = true;
        for (int i = 0; i < nums.length; ++i) {
            if (flag && nums[i] == arr[i]) left = i;
            else if (flag && nums[i] != arr[i]) flag = false;
            if (!flag && nums[i] != arr[i]) right = i;
        }
        ++right;
        if (left >= right) return 0;
        return right - left - 1;
    }

}
