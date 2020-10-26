package LC0_200.LC50_100;

import java.util.ArrayList;
import java.util.List;

public class LC54_Spiral_Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {

        if (matrix.length == 0)
            return new ArrayList<Integer>();

        List<Integer> list = new ArrayList<Integer>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        int count = 0, total = matrix.length * matrix[0].length;

        int i = 0, j = 0;

        int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dir = 0;

        while (count < total - 0) {

            //calculate next point
            int next_i = i + direction[dir][0];
            int next_j = j + direction[dir][1];

            if (needChange(next_i, next_j, matrix, visited)) {
                // change direction
                dir = dir != 3 ? ++dir : 0;
            }
            if (!visited[i][j]){
                list.add(matrix[i][j]);
                visited[i][j] = true;
                count++;
            }
            i += direction[dir][0]; j += direction[dir][1];
        }

        return list;
    }

    private boolean needChange(int next_i, int next_j, int[][] matrix, boolean[][] visited) {
        if (next_i >= matrix.length || next_i < 0 || next_j >= matrix[0].length || next_j < 0)  {
            return true;
        }
        if (next_i != matrix.length && next_j != matrix[0].length && visited[next_i][next_j])
            return true;
        return false;
    }


}
