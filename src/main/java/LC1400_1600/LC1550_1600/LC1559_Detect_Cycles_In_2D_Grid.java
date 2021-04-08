package LC1400_1600.LC1550_1600;

public class LC1559_Detect_Cycles_In_2D_Grid {

    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] root = new int[m * n];
        for (int i = 0; i < m * n; ++i) root[i] = i;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int id1 = i * n + j, id2 = id1, id3 = id1;
                if (i >= 1 && grid[i][j] == grid[i - 1][j]) {
                    id2 = find(root, (i - 1) * n + j);
                    if (id1 != id2) {
                        root[id1] = id2;
                        id1 = id2;
                    }
                }
                if (j >= 1 && grid[i][j] == grid[i][j - 1]) {
                    id3 = find(root, i * n + j - 1);
                    if (i >= 1 && grid[i][j] == grid[i - 1][j] && id2 == id3) return true;
                    if (id1 != id3) root[id1] = id3;
                }
            }

        }
        return false;
    }

    public int find(int[] root, int i) {
        return root[i] == i ? i : (root[i] = find(root, root[i]));
    }

}
