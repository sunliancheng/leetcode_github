package LC0_200.LC0_50;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 *  2020-09-20 2:08 AM at Hangzhou
 */

public class LC41_First_Missing_Positive {

    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums)
            set.add(i);
        Object[] num = set.toArray();
        nums = new int[num.length];
        for (int i = 0; i < num.length; ++i)
            nums[i] = (int) num[i];
        Arrays.sort(nums);

        int i = 0;
        for (int n : nums) {
            if (n > 1 && i == 0)
                return 1;
            else if (n > 0 && i != n - 1)
                return ++i;
            else if (n < 0) {

            } else if (n == 0) {
                i = 0;
            } else
                ++i;
        }
        return ++i;
    }

    @Test
    public void test() {
        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(firstMissingPositive(new int[]{0,2,2,1,1}));
        //System.out.println(firstMissingPositive(new int[]{7,8,9,11,12}));
    }
}
