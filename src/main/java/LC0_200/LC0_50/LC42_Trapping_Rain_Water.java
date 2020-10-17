package LC0_200.LC0_50;

import org.junit.Test;

public class LC42_Trapping_Rain_Water {

    @Test
    public void test() {
        System.out.println(trap_DP(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));;
    }

    /**
     * 3. using stacks
     */
    public int trap_Stacks(int [] height) {
        int ans = 0;


        return ans;
    }


    /**
     * 1. brute force
     * @param height
     * @return
     */
    public int trap_BF(int[] height) {
        int ans = 0;
        for (int i = 0; i < height.length; ++i) {
            int left_max = 0, right_max = 0;
            int l = i, r = i;
            while (l >= 1) {
                --l;
                left_max = left_max > height[l] ? left_max : height[l];
            }
            while (r < height.length - 1) {
                ++r;
                right_max = right_max > height[r] ? right_max : height[r];
            }
            int tem = Math.min(right_max, left_max) - height[i];
            ans += tem <= 0 ? 0 : tem;
        }
        return ans;
    }


    /**
     * 2. dynamic programming
     * @param height
     * @return
     */
    public int trap_DP(int[] height) {
        int ans = 0;
        int[] dp1 = new int[height.length];
        int[] dp2 = new int[height.length];

        int left = 0, right = 0;
        for (int i = 0; i < height.length; ++i) {
            left = left > height[i] ? left : height[i];
            dp1[i] = left;
            right = right > height[height.length - 1 - i] ? right : height[height.length - 1 - i];
            dp2[height.length - 1 - i] = right;
        }
        for (int i = 0; i < height.length; ++i) {
            ans += Math.min(dp1[i], dp2[i]) - height[i];
        }
        return ans;

    }

    public int trap(int[] height) {

        if (height == null)
            return 0;
        int ans = 0;
        int size = height.length;

        int[] left_max = new int[size], right_max = new int[size];

        left_max[0] = height[0];
        for (int i = 0; i < size; ++i) {
            left_max[i] = Math.max(height[i], left_max[i - 1]);
        }
        for (int i = 1; i < size; ++i) {
            ans += Math.min(left_max[i], right_max[i]) - height[i];
        }
        return ans;
    }

}
