package LC200_400.LC250_300;

import org.junit.Test;

import java.util.*;

public class LC300_Longest_Increasing_Subsequence {

    @Test
    public void test() {
        lengthOfLIS(new int[]{3,5,6,2,5,4,19,5,6,7,12});
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        LinkedList<Integer> list = new LinkedList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; ++i)
            if (list.getLast() < nums[i])
                list.addLast(nums[i]);
            else {
                int mid = binary_search(list, nums[i]);
                if (list.get(mid) != nums[i])
                    list.set(mid, nums[i]);
            }
        return list.size();
    }

    int binary_search(List<Integer> list, int key) {
        // left included, right
        int l = 0, r = list.size() - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (mid < list.size() - 1 && list.get(mid) < key && list.get(mid + 1) > key)
                return mid + 1;
            if (list.get(mid) == key)
                return mid;
            if (list.get(mid) > key)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return 0;
    }


    public int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        int ans = 1;
        for (int i = 0; i < nums.length; ++i) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; --j)
                if (nums[i] > nums[j])
                    dp[i] = dp[i] > dp[j] + 1 ? dp[i] : dp[j] + 1;
                else if (nums[i] == nums[j])
                    break;
            ans = ans > dp[i] ? ans : dp[i];
        }
        return ans;
    }
}
