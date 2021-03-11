package LC400_600.LC450_500;

import org.apache.commons.lang.ArrayUtils;
import org.junit.Test;

import java.util.*;


public class LC473_Matchsticks_To_Square {

    @Test
    public void test() {
        //System.out.println(makesquare(new int[]{12,12,12,16,20,24,28,32,36,40,44,48,52,56,60}));
        //System.out.println(makesquare(new int[]{4,3,2,5,2}));
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(5);
        Collections.sort(list, (a, b) -> b - a);
        System.out.println(list.get(0));
    }

    int result = 0;

    public boolean makesquare(int[] nums) {
        nums = Arrays.stream(nums).boxed().sorted((a, b) -> b - a).mapToInt(p -> p).toArray();
        int[] left = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; --i) {
            if (i != nums.length - 1)
                left[i] = left[i + 1] + nums[i];
            else
                left[i] = nums[i];
        }
        if (left.length == 0 || left[0] % 4 != 0) return false;
        dfs(nums, 0, new int[4], left);
        return result > 0;
    }

    public void dfs(int[] nums, int start, int[] sums, int[] left) {
        if (start >= nums.length || result > 0 || !isUseful(sums, left, start)) return;
        for (int i = 0; i <= (start < 4 ? start : 3); ++i) {
            sums[i] += nums[start];
            if (start == nums.length - 1 && check(sums))
                result++;
            dfs(nums, 1 + start, sums, left);
            sums[i] -= nums[start];
        }
    }

    public boolean check(int[] sums) {
        if (sums[0] == sums[1] && sums[0] == sums[2] && sums[0] == sums[3])
            return true;
        return false;
    }

    public boolean isUseful(int[] sums, int[] left, int idx) {
        int max = 0, remain = 0;
        for (int i = 0; i < 4; ++i)
            max = Math.max(max, sums[i]);
        for (int i = 0; i < 4; ++i)
            remain += max - sums[i];
        if (remain > left[idx])
            return false;
        return true;
    }
}
