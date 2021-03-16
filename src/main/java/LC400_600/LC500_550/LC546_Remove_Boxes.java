package LC400_600.LC500_550;

import org.junit.Test;

import java.util.ArrayList;
import java.util.*;
import java.util.List;

public class LC546_Remove_Boxes {

    @Test
    public void test() {
        System.out.println(removeBoxes(new int[]{1,3,2,2,2,3,4,3,1}));
        //List<Integer> list = new ArrayList<>();
        //for (int i : new int[]{1,3,2,2,2,3,4,3,1}) list.add(i);
        //list = delete(list, 2);
        //for (int i : list) System.out.println(i);
        //System.out.println(removeBoxes(new int[]{1,2,1}));
    }

    int[][][] dp = new int[100][100][100];

    public int removeBoxes(int[] boxes) {
        return dfs(0, boxes.length - 1, 0, boxes);
    }

    public int dfs(int l, int r, int k, int[] boxes) {
        if (l > r) return 0;
        if (dp[l][r][k] > 0) return dp[l][r][k];
        dp[l][r][k] = dfs(l, r - 1, 0, boxes) + (k + 1) * (k + 1);
        for (int i = r - 1; i >= 1; --i) {
            if (boxes[i] != boxes[r]) continue;
            int points = dfs(i + 1, r - 1, 0, boxes) + dfs(l, i, k + 1, boxes);
            dp[l][r][k] = Math.max(dp[l][r][k], points);
        }
        return dp[l][r][k];
    }







}
