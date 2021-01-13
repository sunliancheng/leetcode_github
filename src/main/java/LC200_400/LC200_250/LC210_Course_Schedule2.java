package LC200_400.LC200_250;

import LeetCodeUtils.MyMatrix;
import LeetCodeUtils.MyPrint;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC210_Course_Schedule2 {

    @Test
    public void test() {
        System.out.println(findOrder(4,
                MyMatrix.IntMatrixAdapter("[[1,0],[2,0],[3,1],[3,2]]", 4,2)));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] graph = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses], res = new int[numCourses];
        for (int[] pre : prerequisites) {
            graph[pre[1]][pre[0]] = 1;
            ++indegree[pre[0]];
        }
        //  存储入度为 0 的节点
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < indegree.length; ++i)
            if (indegree[i] == 0)
                dq.addLast(i);

        int idx = 0;
        while (!dq.isEmpty()) {
            int u = dq.removeFirst();
            res[idx++] = u;
            for (int i = 0; i < graph[u].length; ++i) {
                if (graph[u][i] == 1) {
                    --indegree[i];
                    if (indegree[i] == 0)
                        dq.addLast(i);
                }
            }
        }

        for (int i = 0; i < indegree.length; ++i)
            if (indegree[i] != 0)
                return new int[]{};
        return res;
    }

}
