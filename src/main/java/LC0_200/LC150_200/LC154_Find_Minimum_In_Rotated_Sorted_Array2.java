package LC0_200.LC150_200;

import LeetCodeUtils.MyMatrix;
import org.junit.Test;

public class LC154_Find_Minimum_In_Rotated_Sorted_Array2 {

    @Test
    public void test() {
        System.out.println(findMin(MyMatrix.
                OneDIntMatrixAdapter("[2,2,2,0,1]")));
    }



    public int findMin(int[] nums) {

        int s = 0, e = nums.length - 1;
        int ans = nums[s];
        while (s <= e) {
            int mid = (s + e) / 2;
            //ans = nums[mid] < ans ? nums[mid] : ans;
            if (nums[s] < nums[mid]) {
                // left side is ordered
                ans = nums[s] < ans ? nums[s] : ans;
                s = mid + 1;
            } else if (nums[s] == nums[mid]) {
                ++s;
            } else {
                // right side is ordered
                ans = nums[mid] < ans ? nums[mid] : ans;
                e = mid - 1;
            }
        }
        return ans;
    }


}
