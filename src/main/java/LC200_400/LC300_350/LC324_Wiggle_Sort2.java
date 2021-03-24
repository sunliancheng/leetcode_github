package LC200_400.LC300_350;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC324_Wiggle_Sort2 {

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] arr = new int[nums.length];
        int i = 1, j = nums.length - 1;
        while (i < nums.length) {
            arr[i] = nums[j--];
            i += 2;
        }
        i = 0;
        while (i < nums.length) {
            arr[i] = nums[j--];
            i += 2;
        }
        for (int idx = 0; idx < nums.length; ++idx)
            nums[idx] = arr[idx];
    }


}
