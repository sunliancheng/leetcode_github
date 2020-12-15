package LC0_200.LC0_50;

import LeetCodeUtils.MyMatrix;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC40_Combination_Sum2 {

    @Test
    public void test() {
        combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        Arrays.sort(candidates);
        combination(candidates, target, 0, comb, ans);
        return ans;
    }

    void combination(int[] candi, int target, int start, List<Integer> comb, List<List<Integer>> ans) {

        if (target == 0) {
            List<Integer> tem = new ArrayList<>();
            tem.addAll(comb);
            ans.add(tem);
            return;
        }

        if (start >= candi.length || candi[start] > target)
            return;
        // deal with duplicates
        int temp = start;
        while (start < candi.length - 1 && candi[start] == candi[start + 1]) {
            ++start;
        }
        if (true) {
            combination(candi, target, start + 1, comb, ans);
            for (int i = temp; i <= start; ++i) {
                int useTime = i - temp;
                int tar = target;
                for (int j = 0; j <= useTime; ++j) {
                    tar -= candi[i];
                    comb.add(candi[i]);
                }
                combination(candi, tar, start + 1, comb, ans);
                for (int j = 0; j <= useTime; ++j) {
                    comb.remove(comb.size() - 1);
                }
            }
            return;
        }
        // not use
//        combination(candi, target, start + 1, comb, ans);
//
//        comb.add(candi[start]);
//        // use the current one
//        combination(candi, target - candi[start], start + 1, comb, ans);
//        // put out
//        comb.remove(comb.size() - 1);
    }
}
