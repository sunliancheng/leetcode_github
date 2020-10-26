package LC0_200.LC50_100;

import LeetCodeUtils.MyMatrix;
import org.junit.Test;

public class LC63_Unique_Paths2 {

    @Test
    public void test() {
        System.out.println(uniquePathsWithObstacles(MyMatrix.IntMatrixAdapter("[[0,0,0],[0,1,0],[0,0,0]]", 3, 3)));
    }


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int R = obstacleGrid.length, C = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1)
            return 0;
        obstacleGrid[0][0] = 1;

        for (int i = 1; i < R; ++i)
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        for (int i = 1; i < C; ++i)
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;

        for (int i = 1; i < R; ++i)
            for (int j = 1; j < C; ++j)
                if (obstacleGrid[i][j] == 0)
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                else
                    obstacleGrid[i][j] = 0;

        return obstacleGrid[R - 1][C - 1];
    }

}
