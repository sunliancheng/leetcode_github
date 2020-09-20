package LC0_200.LC0_50;

import org.junit.Test;

/**
 *  2020-09-20 8:31 PM at Hangzhou
 */
public class LC34_Find_First_And_Last_Position_Of_Element_In_Sorted_Array {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target)
                return new int[]{0, 0};
            else
                return new int[]{-1, -1};
        }
        int pos = binary_search(nums, target, 0, nums.length - 1);
        if (pos == -1)
            return new int[]{-1, -1};
        int low = pos, high = pos;
        while (low >= 0 && nums[low] == nums[pos])
            low--;
        while (high < nums.length && nums[high] == nums[pos])
            high++;
        return new int[]{++low, --high};
    }

    public int binary_search(int[] nums, int target, int low, int high) {
        int pos = 0;
        while (low <= high) {
            pos = (low + high) / 2;
            if (nums[pos] == target)
                return pos;
            else if (nums[pos] > target) {
                high = pos - 1;
            } else
                low = pos + 1;
        }
        return -1;
    }

    @Test
    public void test() {
        System.out.println(binary_search(new int[]{1, 3}, 3, 0, 1));
        int[] arr = new int[]{5, 7, 7, 8, 8, 10};
        System.out.println(searchRange(arr, 6)[0] + " " + searchRange(arr, 6)[1]);
    }


}
