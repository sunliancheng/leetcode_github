package LC0_200.LC0_50;

import org.junit.Test;

/**
 *  2020-09-20 8:31 PM at Hangzhou
 */
public class LC34_Find_First_And_Last_Position_Of_Element_In_Sorted_Array {

    public int[] searchRange(int[] nums, int target) {
        int pos = binary_search(nums, target);
        if (pos == -1)
            return new int[]{-1, -1};
        int l = pos, h = pos;
        while (l >= 0)
            if (nums[l] == target)
                --l;
            else
                break;
        while (h < nums.length)
            if (nums[h] == target)
                ++h;
            else
                break;
        return new int[]{++l, --h};
    }

    public int binary_search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }

    @Test
    public void test() {
        //System.out.println(binary_search(new int[]{1, 3}, 3));
        int[] arr = new int[]{5, 7, 7, 8, 8, 10};
        System.out.println(binary_search(arr, 8));
        System.out.println(searchRange(arr, 8)[0] + " " + searchRange(arr, 8)[1]);
    }


}
