package LC400_600.LC550_600;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC576_Out_Of_Boundary_Paths {

    @Test
    public void test() {
        System.out.println(findPaths(8,50,23,5,26));
    }

    public int findPaths(int m, int n, int N, int i, int j) {
        int[][][] memo = new int[m][n][N + 1];
        for (int[][] l : memo) for (int[] s : l) Arrays.fill(s, -1);
        return dfs(m, n, N - 1, i - 1, j, memo);
    }

    public int dfs(int m, int n, int N, int i, int j, int[][][] memo) {
        if (i == m || j == n || i < 0 || j < 0) return 1;
        if (N == 0) return 0;
        if (memo[i][j][N] != -1) return memo[i][j][N];
        int re = findPaths(m,n,N - 1,i - 1, j) +
                findPaths(m, n, N - 1, i + 1, j) +
                findPaths(m, n, N - 1, i, j + 1) +
                findPaths(m, n, N - 1, i, j - 1);
        memo[i][j][N] = re % 1000000007;
        return memo[i][j][N];
    }



}
