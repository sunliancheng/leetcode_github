package LC200_400.LC300_350;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;

public class LC312_Burst_Balloons {

    @Test
    public void test() {
        Deque<Integer> deque = new LinkedList<>();

        //System.out.println(maxCoins(new int[]{3, 1, 5, 8}));
        System.out.println(maxCoins(new int[]{3, 1, 5, 8}));
    }

    public int maxCoins(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[][] d = new int[nums.length][nums.length];
        for (int i = nums.length - 1; i >= 0; --i) {
            for (int j = i; j < nums.length; ++j) {
                int left = 1, right = 1, leftRes = 0, rightRes = 0;
                if (i > 0)
                    left = nums[i - 1];
                if (j < nums.length - 1)
                    right = nums[j + 1];
                if (i == j)
                    d[i][j] = left * right * nums[i];
                else
                    for (int k = i; k <= j; ++k) {
                        leftRes = rightRes = 0;
                        if (k > i)
                            leftRes = d[i][k - 1];
                        if (k < j)
                            rightRes = d[k + 1][j];
                        int tem = left * right * nums[k] + leftRes + rightRes;
                        d[i][j] = d[i][j] > tem ? d[i][j] : tem;
                    }
            }
        }
        return d[0][nums.length - 1];
    }

    int[][] dp = null;
    public int maxCoins2(int[] nums) {
        if (nums.length == 0)
            return 0;
        dp = new int[nums.length][nums.length];
        return f(0, nums.length - 1, nums);
    }

    int f(int i, int j, int[] nums) {

        if (dp[i][j] != 0)
            return dp[i][j];

        if (i == j) {
            dp[i][j] = nums[i];
            if (i > 0)
                dp[i][j] *= nums[i - 1];
            if (j < nums.length - 1)
                dp[i][j] *= nums[j + 1];
            return dp[i][j];
        }
        int left = 1, right = 1;
        if (i > 0)
            left = nums[i - 1];
        if (j < nums.length - 1)
            right = nums[j + 1];
        for (int k = i; k <= j; ++k) {
            int resLeft = 0, resRight = 0;
            if (i != k)
                resLeft = f(i, k - 1, nums);
            if (k != j)
                resRight = f(k + 1, j, nums);
            dp[i][j] = Math.max(dp[i][j], resLeft + resRight + left * nums[k] * right);
        }
        return dp[i][j];
    }

    /**
     * Given n balloons, indexed from 0 to n-1.
     * Each balloon is painted with a number on it represented by array nums.
     * You are asked to burst all the balloons.
     * If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
     * Here left and right are adjacent indices of i.
     * After the burst, the left and right then becomes adjacent.
     *
     * Find the maximum coins you can collect by bursting the balloons wisely.
     *
     * Note:
     *
     * You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
     * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
     *
     * Input: [3,1,5,8]
     * Output: 167
     * Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
     *              coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
     */
}
