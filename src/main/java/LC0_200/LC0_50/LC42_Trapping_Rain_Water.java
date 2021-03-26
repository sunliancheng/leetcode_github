package LC0_200.LC0_50;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LC42_Trapping_Rain_Water {

    @Test
    public void test() {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    public int trap(int[] height) {
        if (height.length == 0 || height.length == 1) return 0;
        int n = height.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, height[0]});
        pq.offer(new int[]{n - 1, height[n - 1]});
        int result = 0;
        boolean[] visited = new boolean[height.length];
        while (pq.size() > 0) {
            int[] tem = pq.poll();
            result += dfs(pq, height, tem[0], tem[1], visited);
        }
        return result;
    }

    public int dfs(PriorityQueue<int[]> pq, int[] height, int i, int h, boolean[] visited) {
        int water = 0;
        if (h >= height[i]) {
            water += h - height[i];
            visited[i] = true;
            List<Integer> list = new ArrayList<>();
            list.add(i + 1); list.add(i - 1);
            for (int x : list)
                if (x >= 0 && x < height.length && !visited[x]) water += dfs(pq, height, x, h, visited);

        } else {
            visited[i] = true;
            pq.add(new int[]{i, height[i]});
        }
        return water;
    }



}
