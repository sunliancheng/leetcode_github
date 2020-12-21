package LC0_200.LC100_150;

import org.junit.Test;

import java.util.HashMap;

public class LC128_Longest_Consecutive_Sequence {

    @Test
    public void test() {
        System.out.println(longestConsecutive(new int[]{100,4,200,1,3,2}));
    }

    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums.length];
        for (int i : nums)
            map.put(i, i);

        int ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            int count = 1;
            int tem = nums[i];
            while (map.containsKey(++tem))
                count++;
            ans = Math.max(ans, count);
            res[i] = count;
        }
        return ans;

    }

}
