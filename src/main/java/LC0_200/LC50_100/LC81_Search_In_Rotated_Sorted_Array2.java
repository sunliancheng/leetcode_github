package LC0_200.LC50_100;

import LeetCodeUtils.MyMatrix;
import org.junit.Test;

public class LC81_Search_In_Rotated_Sorted_Array2 {

    @Test
    public void test() {
        System.out.println(search(MyMatrix.OneDIntMatrixAdapter("[2,5,6,0,0,1,2]"), 3));
    }

    public boolean search2(int[] nums, int target) {
        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (nums[mid] == target)
                return true;
            if (nums[s] == nums[mid])
                ++s;
            else if (nums[mid] <= nums[e]) {
                if (target > nums[mid] && target <= nums[e])
                    s = mid + 1;
                else
                    e = mid - 1;
            } else {
                if (target >= nums[s] && target < nums[mid])
                    e = mid - 1;
                else
                    s = mid + 1;
            }
        }
        return false;
    }

    public boolean search(int[] nums, int target) {

        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (nums[mid] == target)
                return true;
            if (nums[s] > nums[mid])
                if (nums[mid] < target && target <= nums[e])
                    s = mid + 1;
                else
                    e = mid - 1;
            else if (nums[s] == nums[mid])
                ++s;
            else
                if (nums[mid] > target && target >= nums[s])
                     e = mid - 1;
                else
                    s = mid + 1;
        }
        return false;
    }


}
