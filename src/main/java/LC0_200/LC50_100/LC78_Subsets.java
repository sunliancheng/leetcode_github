package LC0_200.LC50_100;

import java.util.ArrayList;
import java.util.List;

public class LC78_Subsets {

    List<List<Integer>> result = new ArrayList<>();
    int n, k;
    public void backtrack(int first, ArrayList<Integer> cur, int[] nums) {
        if(cur.size() == k) {
            result.add(new ArrayList<Integer>(cur));
            return ;
        }

        for(int i = first; i < n; ++i) {
            cur.add(nums[i]);
            backtrack(i + 1, cur, nums);
            cur.remove(cur.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        for(k = 0; k < n + 1; ++k) {
            backtrack(0, new ArrayList<Integer>(), nums);
        }
        return result;
    }
}
