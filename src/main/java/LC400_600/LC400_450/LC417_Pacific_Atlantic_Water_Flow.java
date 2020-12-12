package LC400_600.LC400_450;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC417_Pacific_Atlantic_Water_Flow {



    public int[] direction = new int[]{-1, 0, 1, 0, -1};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {

        List<List<Integer>> result = new ArrayList<>();

        if (matrix.length == 0 || matrix[0].length == 0)
            return new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        boolean[][] CouldReachP =
                new boolean[matrix.length][matrix[0].length];
        boolean[][] CouldReachA =
                new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < m; ++i) {
            dfs(matrix, CouldReachP, i, 0);
            dfs(matrix, CouldReachA, i, n - 1);
        }
        for (int i = 0; i < n; ++i) {
            dfs(matrix, CouldReachP, 0, i);
            dfs(matrix, CouldReachA, m - 1, i);
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j)
                if (CouldReachP[i][j] && CouldReachA[i][j]) {
                    List<Integer> tem = new ArrayList<>();
                    tem.add(i); tem.add(j);
                    result.add(tem);
                }
        }

        return result;
    }

    void dfs(int[][] matrix, boolean[][] CouldReach, int r, int c) {
        if (CouldReach[r][c])
            return;
        CouldReach[r][c] = true;
        int x, y;
        for (int i = 0; i < 4; ++i) {
            x = r + direction[i]; y = c + direction[i + 1];
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length
                        && matrix[r][c] <= matrix[x][y]) {
                dfs(matrix, CouldReach, x, y);
            }
        }
    }

}
