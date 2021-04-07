package LC800_1000.LC900_950;

import java.util.*;

public class LC947_Most_Stones_Removed_With_Same_Row_Or_Column {

    public int removeStones2(int[][] stones) {
        int N = stones.length;
        int[][] graph = new int[N][N];
        for (int i = 0; i < N; ++i) {
            for (int j = i + 1; j < N; ++j) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    graph[i][++graph[i][0]] = j;
                    graph[j][++graph[j][0]] = i;
                }
            }
        }
        int ans = 0;
        boolean[] seen = new boolean[N];
        for (int i = 0; i < N; ++i) {
            if (!seen[i]) {
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                seen[i] = true;
                ans--;
                while (!stack.isEmpty()) {
                    int node = stack.pop();
                    ans++;
                    for (int k = 1; k <= graph[node][0]; ++k) {
                        int nei = graph[node][k];
                        if (!seen[nei]) {
                            stack.push(nei);
                            seen[nei] = true;
                        }
                    }
                }
            }
        }
        return ans;
    }

    public int removeStones(int[][] stones) {
        int N = stones.length;
        DSU dsu = new DSU(20000);
        for (int[] stone : stones) dsu.union(stone[0], stone[1] + 10000);
        Set<Integer> seen = new HashSet<>();
        for (int[] stone : stones) seen.add(dsu.find(stone[0]));
        return N - seen.size();
    }
}

class DSU {
    int[] parent;
    public DSU(int N) {
        parent = new int[N];
        for (int i = 0; i < N; ++i)
            parent[i] = i;
    }

    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y) {
        parent[find(x)] = find(y);
    }
}
