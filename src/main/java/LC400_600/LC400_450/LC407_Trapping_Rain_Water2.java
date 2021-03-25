package LC400_600.LC400_450;

import LeetCodeUtils.MyMatrix;
import LeetCodeUtils.MyPrint;
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

        int[][] visited = new int[m][n];
        for (int i = 0; i < m; ++i) {
            visited[i][0] = -1;
            pq.add(new int[]{i, 0, heightMap[i][0]});
            visited[i][n - 1] = -1;
            pq.add(new int[]{i, n - 1, heightMap[i][n - 1]});
        }

        for (int j = 1; j < n - 1; ++j) {
            visited[0][j] = -1;
            pq.add(new int[]{0, j, heightMap[0][j]});
            visited[m - 1][j] = -1;
            pq.add(new int[]{m - 1, j, heightMap[m - 1][j]});
        }

        int result = 0;
        while (pq.size() > 0) {
            int[] node = pq.poll();
            handle(pq, heightMap, node[0], node[1], node[2], visited);
        }
        //MyPrint.print2DMatrix(heightMap);
        //MyPrint.print2DMatrix(visited);
        pq.clear();
        for (int i = 0; i < visited.length; ++i)
            for (int j = 0; j < visited[0].length; ++j)
                if (visited[i][j] != -1) result += visited[i][j] - heightMap[i][j];

        return result;
    }

    public void handle (PriorityQueue<int[]> pq, int[][] heightMap, int i, int j, int h, int[][] visited) {
        if (h <= heightMap[i][j]) {
            visited[i][j] = -1;
            for (int k = 0; k < directions.length - 1; ++k) {
                int x = directions[k] + i, y = directions[k + 1] + j;
                if (x >= 0 && y >= 0 && x <= visited.length - 1 && y <= visited[0].length - 1 && visited[x][y] != -1)
                    handle(pq, heightMap, x, y, heightMap[i][j], visited);
            }
        } else {
            if (visited[i][j] == 0) visited[i][j] = h;
            visited[i][j] = Math.min(visited[i][j], h);
            for (int k = 0; k < directions.length - 1; ++k) {
                int x = directions[k] + i, y = directions[k + 1] + j;
                if (x >= 0 && y >= 0 && x <= visited.length - 1 && y <= visited[0].length - 1 && visited[x][y] != -1 && visited[x][y] != 0)
                    visited[i][j] = Math.min(visited[i][j], visited[x][y]);
            }
        }
    }

}
