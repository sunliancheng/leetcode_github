package LC400_600.LC450_500;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC491_Increasing_Subsequences {

    @Test
    public void test() {
        Set<List<Integer>> re = new HashSet<>();
        List<Integer> ls = new ArrayList<>();
        ls.add(2);
        List<Integer> ls3 = new ArrayList<>();
        ls3.add(2);
        //ls3.add(2);
        re.add(ls);
        re.add(ls3);
        findSubsequences(new int[]{4,6,7,7});
    }

    public void dfs(Set<List<Integer>> ans, List<Integer> path, int start, int cur, int[] nums){
        if (start >= nums.length) return;
        for (int i = start; i < nums.length; ++i) {
            if (nums[i] >= cur) {
                path.add(nums[i]);
                if (path.size() > 1) ans.add(new ArrayList<>(path));
                dfs(ans, path, i + 1, nums[i], nums);
                path.remove(path.size() - 1);
            } else
                continue;
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> ans= new HashSet<>();
        if(nums==null || nums.length==0) return new ArrayList<>();
        dfs(ans, new ArrayList<>(), 0, -101, nums);
        return new ArrayList<>(ans);
    }

    public List<List<Integer>> findSubsequences2(int[] nums) {
        List<List<Integer>> prev = new ArrayList<>();
        List<List<Integer>> cur = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; --i) {
            if (i == 0 && prev.size() != 0) {
                for (List<Integer> ls : prev)
                    if (ls.size() != 1)
                        cur.add(ls);
            } else if (prev.size() != 0)
                cur.addAll(prev);
            if (i != 0 && (i < nums.length - 1 && nums[i] != nums[i + 1] || i == nums.length - 1)) {
                List<Integer> t = new ArrayList<>();
                t.add(nums[i]);
                cur.add(t);
            }
            for (List<Integer> ls : prev) {
                if (nums[i] <= ls.get(0)) {
                    List<Integer> tem = new ArrayList<>();
                    tem.add(nums[i]);
                    tem.addAll(ls);
                    cur.add(tem);
                }
            }
            prev = cur;
            cur = new ArrayList<>();
        }
        return prev;
    }

}
