package LC200_400.LC200_250;

import java.util.TreeSet;

public class LC220_Contains_Duplicate3 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length == 0 || k <= 0)
            return false;

        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < nums.length; i++) {
            Long floor = set.floor(1L * nums[i] + t);
            Long ceil = set.ceiling(1L * nums[i] - t);
            if ((floor != null && floor >= nums[i]) || (ceil != null && ceil <= nums[i]))
                return true;

            set.add(1L * nums[i]);
            if (i >= k)
                set.remove(1L * nums[i - k]);
        }

        return false;
    }
}
