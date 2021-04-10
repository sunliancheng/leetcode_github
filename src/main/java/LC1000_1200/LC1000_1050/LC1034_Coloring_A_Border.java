package LC1000_1200.LC1000_1050;

public class LC1034_Coloring_A_Border {

    int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    boolean[][] visited;

    private void dfs(int[][] grid, int r0, int c0, int origColor, int newColor, int n, int m) {

        visited[r0][c0] = true;
        for(int[] d: dir) {
            int x = r0 + d[0];
            int y = c0 + d[1];

            // if next cell is either boundary OR of diff color but not previously visited
            if(x>=n || x<0 || y>=m || y<0 || (!visited[x][y] && grid[x][y]!=origColor)) {
                grid[r0][c0] = newColor;
                continue;
            }

            // continue if previously visited
            if(visited[x][y])
                continue;

            dfs(grid, x, y, origColor, newColor, n, m);
        }
    }

    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        if(grid[r0][c0] == color)
            return grid;

        int n = grid.length;
        int m = grid[0].length;
        visited = new boolean[n][m];

        dfs(grid, r0, c0, grid[r0][c0], color, n, m);
        return grid;
    }

}
