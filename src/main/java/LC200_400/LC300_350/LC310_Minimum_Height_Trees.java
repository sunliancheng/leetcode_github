package LC200_400.LC300_350;

import LeetCodeUtils.MyMatrix;
import LeetCodeUtils.MyPrint;
import org.junit.Test;

import java.util.*;

public class LC310_Minimum_Height_Trees {

    @Test
    public void test() {
        findMinHeightTrees(6, MyMatrix.IntMatrixAdapter("[[3,0],[3,1],[3,2],[3,4],[5,4]]", 5, 2));
        findMinHeightTrees(2, new int[][]{{0, 1}});

    }

    int min = Integer.MAX_VALUE;
    List<Integer> res = new ArrayList<>();
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[][] matrix = new int[n][n];
        int[] edge_size = new int[n];
        for (int[] edge : edges) {
            ++edge_size[edge[0]];
            ++edge_size[edge[1]];
            matrix[edge[0]][edge[1]] = 1;
            matrix[edge[1]][edge[0]] = 1;
        }

        //MyPrint.print2DMatrix(matrix);
        boolean flag = false;
        // do bfs search for each node that has more than one edges
        for (int i = 0; i < n; ++i) {
            if (edge_size[i] == 1 || edge_size[i] == 0)
                continue;
            flag = true;
            bfs(i, matrix);
        }
        //MyPrint.print2DMatrix(matrix);
        if (!flag) {
            for (int i = 0; i < n; ++i)
                bfs(i, matrix);
        }

        return res;
    }

    void bfs(int i, int[][] matrix) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        Set<Integer> set = new HashSet<>();
        set.add(i);
        int level = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            ++level;
            if (level > min)
                return;
            while (--n >= 0) {
                int root = queue.poll();
                for (int j = 0; j < matrix.length; ++j) {
                    if (matrix[root][j] == 1 && !set.contains(j)) {
                        queue.offer(j);
                        //System.out.print(j + " 第 " + level + "层");
                        set.add(j);
                    }
                }
                //System.out.println();
            }
        }
        if (level < min) {
            min = level;
            res.clear();
        }
            res.add(i);
    }

}
