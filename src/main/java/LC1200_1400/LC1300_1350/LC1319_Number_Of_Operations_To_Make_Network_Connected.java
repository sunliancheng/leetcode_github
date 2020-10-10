package LC1200_1400.LC1300_1350;

import org.junit.Test;

public class LC1319_Number_Of_Operations_To_Make_Network_Connected {

    @Test
    public void test() {
        System.out.println(makeConnected(4, new int[][]{{0, 1}, {0, 2}, {1, 2}}));
    }

    private int[] par;
    private int[] rank;

    public int makeConnected(int n, int[][] connections) {

        init(n);
        int length = connections.length;
        int NumLeft = 0;

        for (int i = 0; i < length; ++i)
            if (find(connections[i][0]) == find(connections[i][1]))
                NumLeft++;
            else
                unite(connections[i][0], connections[i][1]);
        int num = 0;
        for (int i = 0; i < n; ++i)
            if (par[i] == i)
                num++;

        return NumLeft - num + 1 >= 0 ? num - 1 : - 1;
    }

    public void init(int n) {
        par = new int[n];
        for (int i = 0; i < n; ++i) {
            par[i] = i;
        }
        rank = new int[n];
    }

    public int find(int x) {
        return par[x] == x ? x : find(par[x]);
    }

    public void unite(int x, int y) {
        int xp = find(x), yp = find(y);
        if (xp == yp)
            return;
        if (rank[x] < rank[y])
            par[xp] = yp;
        else {
            if (rank[x] == rank[y])
                rank[x]++;
            par[yp] = xp;
        }
    }






    /**
     * There are n computers numbered from 0 to n-1
     * connected by ethernet cables connections forming a network where connections[i] = [a, b] represents a connection between computers a and b. Any computer can reach any other computer directly or indirectly through the network.
     *
     * Given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected. Return the minimum number of times you need to do this in order to make all the computers connected. If it's not possible, return -1.
     *
     *
     *
     * Example 1:
     *
     *
     *
     * Input: n = 4, connections = [[0,1],[0,2],[1,2]]
     * Output: 1
     * Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.
     * Example 2:
     *
     *
     *
     * Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
     * Output: 2
     * Example 3:
     *
     * Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
     * Output: -1
     * Explanation: There are not enough cables.
     * Example 4:
     *
     * Input: n = 5, connections = [[0,1],[0,2],[3,4],[2,3]]
     * Output: 0
     */
}
