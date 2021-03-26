package LC400_600.LC400_450;

import LeetCodeUtils.MyMatrix;
import org.junit.Test;

import java.util.PriorityQueue;

public class LC407_Trapping_Rain_Water2 {

    @Test
    public void test() {
        System.out.println(trapRainWater(MyMatrix.IntMatrixAdapter("[[12,13,1,12],[13,4,13,12],[13,8,10,12],[12,13,12,12],[13,13,13,13]]", 5, 4)));
    }

    private int[] directions = new int[]{-1, 0, 1, 0, -1};
    public int trapRainWater(int[][] heightMap) {

        int m = heightMap.length, n = heightMap[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            visited[i][0] = true;
            pq.add(new int[]{i, 0, heightMap[i][0]});
            visited[i][n - 1] = true;
            pq.add(new int[]{i, n - 1, heightMap[i][n - 1]});
        }

        for (int j = 1; j < n - 1; ++j) {
            visited[0][j] = true;
            pq.add(new int[]{0, j, heightMap[0][j]});
            visited[m - 1][j] = true;
            pq.add(new int[]{m - 1, j, heightMap[m - 1][j]});
        }

        int result = 0;
        while (pq.size() > 0) {
            int[] node = pq.poll();
            result += dfs(pq, heightMap, node[0], node[1], node[2], visited);
        }
        return result;
    }

    public int dfs (PriorityQueue<int[]> pq, int[][] heightMap, int i, int j, int h, boolean[][] visited) {
        int water = 0;
        if (h >= heightMap[i][j]) {
            visited[i][j] = true;
            water += h - heightMap[i][j];
            for (int k = 0; k < directions.length - 1; ++k) {
                int x = directions[k] + i, y = directions[k + 1] + j;
                if (x >= 0 && y >= 0 && x < heightMap.length && y < heightMap[0].length && !visited[x][y])
                    water += dfs(pq, heightMap, x, y, h, visited);
            }
        } else {
            visited[i][j] = true;
            pq.add(new int[]{i, j, heightMap[i][j]});
        }
        return water;
    }

}
