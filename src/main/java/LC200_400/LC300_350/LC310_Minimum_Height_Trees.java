package LC200_400.LC300_350;

import LeetCodeUtils.MyMatrix;
import LeetCodeUtils.MyPrint;
import org.junit.Test;

import java.util.*;

public class LC310_Minimum_Height_Trees {

    @Test
    public void test() {
        System.out.println(findMinHeightTrees(6, MyMatrix.IntMatrixAdapter("[[3,0],[3,1],[3,2],[3,4],[5,4]]", 5, 2)));;
        System.out.println(findMinHeightTrees(2, new int[][]{{0, 1}}));

    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        HashSet<Integer>[] graph = new HashSet[n];
        for (int i = 0; i < n; ++i) graph[i] = new HashSet<>();
        int[] edge_size = new int[n];
        for (int[] edge : edges) {
            ++edge_size[edge[0]];
            ++edge_size[edge[1]];
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < edge_size.length; ++i)
            if (edge_size[i] == 1) q.offer(i);

        while (!q.isEmpty()) {
            res = new ArrayList<>();
            int size = q.size();
            while (--size >= 0) {
                int cur = q.poll();
                res.add(cur);
                for (int v : graph[cur]) {
                    if (--edge_size[v] == 1) q.offer(v);
                }
            }
        }
        return res;
    }



}
