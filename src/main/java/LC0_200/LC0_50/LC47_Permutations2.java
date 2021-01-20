package LC0_200.LC0_50;

import org.junit.Test;

import java.util.*;

public class LC47_Permutations2 {

    @Test
    public void test() {
        permuteUnique(new int[]{-1,2,-1,2,1,-1,2,1});
    }

    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        dfs(nums, 0);
        for (List<Integer> ls : res) {
            for (Integer i : ls)
                System.out.print(i);
            System.out.println();
        }
        return res;
    }

    void dfs(int[] nums, int level) {
        if (level == nums.length - 1) {
            List<Integer> ls = new ArrayList<>();
            for (int i : nums)
                ls.add(i);
            res.add(ls);
            return;
        }
        boolean[] used = new boolean[20];
        for (int i = level; i < nums.length; ++i) {
            if (used[nums[i] + 10])
                continue;
            else
                used[nums[i] + 10] = true;
            int tem = nums[level];
            nums[level] = nums[i]; nums[i] = tem;
            dfs(nums, level + 1);
            nums[i] = nums[level]; nums[level] = tem;
        }

    }

}
