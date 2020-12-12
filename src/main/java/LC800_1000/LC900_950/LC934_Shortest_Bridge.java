package LC800_1000.LC900_950;

import LeetCodeUtils.MyMatrix;
import LeetCodeUtils.MyPrint;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class LC934_Shortest_Bridge {

    @Test
    public void test() {
        System.out.println(shortestBridge(MyMatrix.
                IntMatrixAdapter("[[1,1,1,1,1]," +
                        "[1,0,0,0,1]," +
                        "[1,0,1,0,1]," +
                        "[1,0,0,0,1]," +
                        "[1,1,1,1,1]]", 5, 5)));
    }



    int[] direction = new int[]{-1, 0, 1, 0, -1};
    public int shortestBridge(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> points = new LinkedList<>();
        boolean flipped = false;
        // dfs 查找第一个岛屿，全部 1 设置成 2
        for (int i = 0; i < m; ++i) {
            if (flipped)
                break;
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    dfs(points, grid, m, n, i, j);
                    flipped = true;
                    break;
                }
            }
        }

        // bfs 查找第二个岛屿，并把经过 0 的地方赋值为 2
        int x, y;
        int level = 0;
        while (!points.isEmpty()) {
            int n_point = points.size();
            ++level;
            while (n_point-- > 0) {
                int[] top = points.poll();
                for (int i = 0; i < 4; ++i) {
                    x = top[0] + direction[i]; y = top[1] + direction[i + 1];
                    if (x < 0 || y < 0 || x >= m || y >= n)
                        continue;
                    if (grid[x][y] == 1)
                        return level;
                    if (grid[x][y] == 0) {
                        points.offer(new int[]{x, y});
                        grid[x][y] = 2;
                    }
                }

            }
        }
        return 0;
    }

    void dfs(Queue<int[]> points, int[][] grid, int m, int n, int i, int j) {
        if (i < 0 || j < 0 || i == m || j == n || grid[i][j] == 2)
            return;
        if (grid[i][j] == 0) {
            points.offer(new int[]{i, j});
            return;
        }
        grid[i][j] = 2;
        dfs(points, grid, m, n, i - 1, j);
        dfs(points, grid, m, n, i + 1, j);
        dfs(points, grid, m, n, i, j - 1);
        dfs(points, grid, m, n, i, j + 1);
    }

}
