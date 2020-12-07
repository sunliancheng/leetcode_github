package LC200_400.LC200_250;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC216_Combination_Sum3 {public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> results = new ArrayList<List<Integer>>();
    LinkedList<Integer> comb = new LinkedList<Integer>();
    this.backtrack(n, k, comb, 0, results);
    return results;
}

    private void backtrack(int remain, int k, LinkedList<Integer> comb, int next_start, List<List<Integer>> results) {
        if (remain == 0 && comb.size() == k) {
            results.add(new ArrayList<Integer>(comb));
            return;
        } else if (remain < 0 || comb.size() == k)
            return;
        for (int i = next_start; i < 9; ++i) {
            comb.add(i + 1);
            this.backtrack(remain - i - 1, k, comb, i + 1, results);
            comb.removeLast();
        }
    }

}
