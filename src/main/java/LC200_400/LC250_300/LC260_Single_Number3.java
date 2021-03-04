package LC200_400.LC250_300;

import org.junit.Test;

/**
 *  Explanation on
 *  https://blog.csdn.net/weixin_40037938/article/details/114361683
 */
public class LC260_Single_Number3 {

    @Test
    public void test() {
        singleNumber(new int[]{1,2,1,3,2,5});
    }


    public int[] singleNumber(int[] nums) {
        if (nums.length <= 2) return nums;
        int re = 0;
        for (int i : nums)
            re ^= i;
        int i = 0;
        while (((re >> i) & 1) != 1)
            ++i;
        int a = 0, b = 0;
        for (int n : nums) {
            if (((n >> i) & 1) == 1)
                a ^= n;
            else
                b ^= n;
        }
        return new int[]{a, b};
    }
}
