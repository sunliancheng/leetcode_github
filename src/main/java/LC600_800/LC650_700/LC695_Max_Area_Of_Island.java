package LC600_800.LC650_700;

import LeetCodeUtils.MyMatrix;
import LeetCodeUtils.MyPrint;
import javafx.util.Pair;
import org.junit.Test;

import java.util.Stack;

public class LC695_Max_Area_Of_Island {

    @Test
    public void test() {
        System.out.println(maxAreaOfIsland(MyMatrix.IntMatrixAdapter("[[0,0,1,0,0,0,0,1,0,0,0,0,0]," +
                "[0,0,0,0,0,0,0,1,1,1,0,0,0]," +
                "[0,1,1,0,1,0,0,0,0,0,0,0,0]," +
                "[0,1,0,0,1,1,0,0,1,0,1,0,0]," +
                "[0,1,0,0,1,1,0,0,1,1,1,0,0]," +
                "[0,0,0,0,0,0,0,0,0,0,1,0,0]," +
                "[0,0,0,0,0,0,0,1,1,1,0,0,0]," +
                "[0,0,0,0,0,0,0,1,1,0,0,0,0]]", 8, 13)));
    }

    int max = 0, res = 0;
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; ++i)
            for (int j = 0; j < grid[0].length; ++j) {
                if (!visited[i][j]) {
                    max = 0;
                    dfs(grid, visited, i, j);
                    res = res > max ? res : max;
                }
            }
        return res;
    }

    public void dfs(int[][] grid, boolean[][] visited, int i, int j) {
        if ((i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) || grid[i][j] == 0 || visited[i][j])
            return;
        visited[i][j] = true;
        ++max;
        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i, j + 1);
        dfs(grid, visited, i, j - 1);
    }



//    public void method2(int[][] grid) {
//        int[] direction = new int[]{-1, 0, 1, 0, -1};
//        int m = grid.length, n = m > 0 ? grid[0].length : 0,
//                local_area, area = 0, x, y;
//
//        for (int i = 0; i < m; ++i) {
//            for (int j = 0; j < n; ++j) {
//                if (grid[i][j] == 1) {
//                    local_area = 1;
//                    grid[i][j] = 0;
//                    Stack<Pair<Integer, Integer>> island = new Stack<>();
//                    island.push(new Pair<>(i, j));
//                    while (!island.empty()) {
//                        Pair<Integer, Integer> p = island.pop();
//                        for (int k = 0; k < 4; ++k) {
//                            x = r + direction[k], y = c + direction[k + 1];
//                        }
//                    }
//
//                }
//            }
//        }
//    }

}
