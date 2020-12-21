package LC200_400.LC300_350;

import org.junit.Test;

public class LC303_Range_Sum_Query_Immutable {

    @Test
    public void test() {
        NumArray numArray = new NumArray(new int[]{-2,0,3,-5,2,-1});
        System.out.println(numArray.sumRange(0,2));
    }

}

class NumArray {

    int[] psum;
    public NumArray(int[] nums) {
        psum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            psum[i + 1] = nums[i];
            if (i == 0)
                continue;
            psum[i + 1] += psum[i];
        }
    }

    public int sumRange(int i, int j) {
        return psum[j + 1] - psum[i];
    }
}