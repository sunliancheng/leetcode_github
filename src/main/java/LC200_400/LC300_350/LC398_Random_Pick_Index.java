package LC200_400.LC300_350;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class LC398_Random_Pick_Index {
}

class Solution {

    Map<Integer, List<Integer>> map = null;

    public Solution(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.getOrDefault(nums[i], null) == null) {
                List<Integer> ls = new ArrayList<>();
                ls.add(i);
                map.put(nums[i], ls);
            } else {
                map.get(nums[i]).add(i);
            }
        }
    }

    public int pick(int target) {
        List<Integer> ls = map.get(target);
        Random random = new Random();
        int i = random.nextInt(ls.size());
        return ls.get(i);
    }
}