package LC400_600.LC450_500;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LC494_Target_Sum {

    @Test
    public void test() {
        List<Integer> ls1 = new ArrayList<>();
        ls1.add(1);
        List<Integer> ls2 = new ArrayList<>();
        ls2.add(1);
        System.out.println(ls1.equals(ls2));
        //int i = findTargetSumWays(new int[]{1,1,1,1,1}, 3);
        //System.out.println(i);
    }

    int result = 0;

    public int findTargetSumWays(int[] nums, int S) {
        dfs(0, S, nums, 0);
        return result;
    }

    public void dfs(int sum, int target, int[] nums, int start) {
        if (start > nums.length) return;

        if (start == nums.length && sum == target) {
            result++;
        } else if (start < nums.length) {
            dfs(sum + nums[start], target, nums, start + 1);
            dfs(sum - nums[start], target, nums, start + 1);
        }
    }

}
