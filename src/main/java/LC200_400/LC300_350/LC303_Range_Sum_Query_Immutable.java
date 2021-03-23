package LC200_400.LC300_350;

import org.junit.Test;

public class LC303_Range_Sum_Query_Immutable {

    @Test
    public void test() {
        NumArray2 numArray2 = new NumArray2(new int[]{-2,0,3,-5,2,-1});
        System.out.println(numArray2.sumRange(0,2));
    }

}

class NumArray2 {

    int[] psum;
    public NumArray2(int[] nums) {
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