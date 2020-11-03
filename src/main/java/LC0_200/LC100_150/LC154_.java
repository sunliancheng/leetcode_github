package LC0_200.LC100_150;

import LeetCodeUtils.MyMatrix;
import org.junit.Test;

public class LC154_ {

    @Test
    public void test() {
        System.out.println(findMin(MyMatrix.OneDIntMatrixAdapter("[2,2,2,0,1]")));
    }

    public int findMin(int[] nums) {
        int ans = 0;
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                right--;
            }
        }

        return nums[left];
    }

}
