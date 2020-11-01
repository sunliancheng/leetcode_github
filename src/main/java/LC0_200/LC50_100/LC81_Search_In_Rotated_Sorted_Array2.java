package LC0_200.LC50_100;

import LeetCodeUtils.MyMatrix;
import org.junit.Test;

public class LC81_Search_In_Rotated_Sorted_Array2 {

    @Test
    public void test() {
        System.out.println(search(MyMatrix.OneDIntMatrixAdapter("[2,5,6,0,0,1,2]"), 0));
    }

    public boolean search(int[] nums, int target) {
        boolean ans = false;

        for (int i : nums)
            if (i == target)
                return true;

        return ans;
    }

}
