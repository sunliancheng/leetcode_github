package LC800_1000.LC900_950;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC932_Beautiful_Arrays {

    @Test
    public void test() {
        int[] res = beautifulArray(5);
        for (int i : res)
            System.out.print(i);
    }

    public int[] beautifulArray3(int N) {

        return null;
    }

    public int[] beautifulArray(int N) {
        List<int[]> res = new ArrayList<>();
        res.add(new int[]{1});
        res.add(new int[]{1});
        for (int i = 1; i < N; ++i) {
            int[] tem = new int[i + 1];
            res.add(tem);
            int t = 0;
            for (int l : res.get((i + 2) / 2))
                tem[t++] = 2 * l - 1;
            for (int r : res.get((i + 1) / 2))
                tem[t++] = 2 * r;
        }
        return res.get(N);
    }


    HashMap<Integer, int[]> memo;
    public int[] beautifulArray2(int N) {
        memo = new HashMap<>();
        return f(N);
    }

    private int[] f(int n) {
        if (memo.containsKey(n))
            return memo.get(n);
        int [] ans = new int[n];
        if (n == 1)
            ans[0] = 1;
        else {
            int t = 0;
            for (int x : f((n + 1) / 2))  // odds
                ans[t++] = 2 * x - 1;
            for (int x : f(n / 2))   // even
                ans[t++] = 2 * x;
        }
        memo.put(n, ans);
        return ans;
    }

}
