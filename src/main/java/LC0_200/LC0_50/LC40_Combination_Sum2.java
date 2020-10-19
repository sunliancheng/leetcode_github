package LC0_200.LC0_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC40_Combination_Sum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        Arrays.sort(candidates);
        combination(candidates, target, 0, comb, ans);
        return ans;
    }

    private void combination(int[] candi, int target, int start, List<Integer> comb, List<List<Integer>> ans) {

        for(int i = start; i < candi.length; ++i) {
            //remove duplicates
            if(i > start && candi[i] == candi[i - 1])
                continue;
            if(candi[i] == target) {
                List<Integer> newComb = new ArrayList<>(comb);
                newComb.add(candi[i]);
                ans.add(newComb);
            } else if(candi[i] < target) {
                List<Integer> newComb = new ArrayList<>(comb);
                newComb.add(candi[i]);
                combination(candi, target - candi[i], i + 1, newComb, ans);
            } else{
                break;
            }
        }
    }
}
