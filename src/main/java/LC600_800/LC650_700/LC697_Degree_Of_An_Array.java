package LC600_800.LC650_700;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC697_Degree_Of_An_Array {

    @Test
    public void test() {
        System.out.println(findShortestSubArray(new int[]{1,2,2,3,1}));
    }

    public int findShortestSubArray(int[] nums) {
        int ans = Integer.MAX_VALUE;
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> last = new HashMap<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        List<Integer> maxList = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            int cou = count.getOrDefault(nums[i], 0);
            count.put(nums[i], 1 + cou);
            if (!first.containsKey(nums[i])) {
                first.put(nums[i], i);
                last.put(nums[i], i);
            } else
                last.put(nums[i], i);
            int cur_max = count.get(nums[i]);
            if (max < cur_max) {
                max = cur_max;
                maxList.clear();
                maxList.add(nums[i]);
            } else if (max == cur_max) {
                maxList.add(nums[i]);
            }
        }
        for (int i : maxList) {
            int dis = last.get(i) - first.get(i);
            ans = ans < dis ? ans : dis;
        }
        return ++ans;
    }

}
