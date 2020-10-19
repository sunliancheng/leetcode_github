package LC0_200.LC0_50;

import java.util.*;

public class LC39_Combination_Sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        HashMap<Integer, List<List<Integer>>> sums = new HashMap<>();

        for(int i = 0; i < candidates.length; ++i) {
            sums.computeIfAbsent(candidates[i], (key) -> new ArrayList<>()).add(Arrays.asList(candidates[i]));

            for(int j = candidates[i] + 1; j <= target; j++) {
                List<List<Integer>> sumsSoFar = sums.computeIfAbsent(j - candidates[i], (key) -> new ArrayList<>());

                for(List<Integer> sum : sumsSoFar) {
                    List<Integer> n = new ArrayList<>(sum);
                    n.add(candidates[i]);
                    sums.computeIfAbsent(j, (key) -> new ArrayList<>()).add(n);
                }
            }
        }
        return sums.getOrDefault(target, Collections.emptyList());
    }
}
