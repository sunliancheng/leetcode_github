package LC400_600.LC550_600;

import org.junit.Test;

import java.util.HashMap;

public class LC594_Longest_Harmonious_Subsequence {

    @Test
    public void test() {
        System.out.println(findLHS(new int[]{}));
    }

    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int cou = map.getOrDefault(nums[i], 0);
            map.put(nums[i], ++cou);
        }
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            int tem = map.getOrDefault(nums[i] + 1, 0);
            int tem2 = map.getOrDefault(nums[i] - 1, 0);
            tem = tem > tem2 ? tem : tem2;
            if (tem != 0)
                tem += map.getOrDefault(nums[i], 0);
            max = max > tem ? max : tem;
        }
        return max;

    }

}
