package LC400_600.LC550_600;

import org.junit.Test;

public class LC560_Subarray_Sum_Equals_K {

    @Test
    public void test() {
        System.out.println(subarraySum(new int[]{1,1,1}, 2));
    }


    public int subarraySum(int[] nums, int k) {
        for (int i = 0; i < nums.length; ++i) {
            if (i == 0)
                continue;
            nums[i] += nums[i - 1];
        }
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            boolean flag = false, flag2 = false;
            if (nums[i] == k)
                ++count;
            for (int j = i - 1; j >= 0; --j) {
                if (flag)
                    if (flag2)
                        break;
                if (nums[i] - nums[j] == k) {
                    count++;
                    flag = true;
                } else {
                    if (flag)
                        flag2 = true;
                }
            }
        }
        return count;
    }

}
