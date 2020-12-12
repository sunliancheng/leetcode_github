package LC0_200.LC50_100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC77_Combintions {

    @Test
    public void test() {
        combine(4, 2);
    }

    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {

        List<Integer> comb = new ArrayList<>();
        backtracking(comb, 0, 1, n, k);

//        for (List<Integer> t : res) {
//
//            for (int i : t)
//                System.out.print(i + " ");
//            System.out.println();
//        }

        return res;
    }

    void backtracking(List<Integer> comb,
                      int count, int pos, int n, int k) {
        if (count == k) {
            List<Integer> tem = new ArrayList<>();
            tem.addAll(comb);
            res.add(tem);
            return;
        }
        for (int i = pos; i <= n; ++i) {
            comb.add(i); ++count;
            backtracking(comb, count, i + 1, n, k);
            comb.remove(--count);
        }
    }

}
