package LC0_200.LC0_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15_3_Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; ++i) {
            if(i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int[] re = new int[3];
            List<List<Integer>> r = two_sum(nums, 0 - nums[i], i);
            for(List<Integer> l : r)
                res.add(l);
        }
        return res;
    }

    public List<List<Integer>> two_sum(int[] nums, int target, int cur) {
        int low = cur + 1, high = nums.length - 1;
        List<List<Integer>> result = new ArrayList<>();
        while(true) {
            if(low >= high) {
                return result;
            } else if(nums[low] + nums[high] == target) {
                List<Integer> resu = new ArrayList<>();
                resu.add(nums[low]); resu.add(nums[high]); resu.add(nums[cur]); result.add(resu);
                while(low + 1 < high && nums[low] == nums[low + 1])
                    low++;
//                while(high - 1 > low && nums[high] == nums[high - 1])
                //                  high--;
                low++; high--;
            } else if(nums[low] + nums[high] < target) {
                while(low + 1 < high && nums[low] == nums[low + 1])
                    low++;
                low++;
            } else if(nums[low] + nums[high] > target) {
                while(high - 1 > low && nums[high] == nums[high - 1])
                    high--;
                high--;
            }
        }
    }

}
