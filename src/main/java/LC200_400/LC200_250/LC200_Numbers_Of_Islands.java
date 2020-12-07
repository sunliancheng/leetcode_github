package LC200_400.LC200_250;

public class LC200_Numbers_Of_Islands {
    public int numIslands(char[][] grid) {
        int re = 0;
        for(int i = 0; i < grid.length; ++i)
            for(int j = 0; j < grid[0].length; ++j)
                if(grid[i][j] == '1') {
                    re++;
                    dfs(grid, i, j);
                }
        return re;
    }


    void dfs(char[][] grid, int y, int x) {
        //if out of bounds or at a cell with '0' or '*', simply stop and return
        if(x < 0 || x >= grid[0].length || y < 0 || y >= grid.length || grid[y][x] != '1')
            return;
        grid[y][x] = '*';
        dfs(grid, y + 1, x);
        dfs(grid, y, x + 1);
        dfs(grid, y - 1, x);
        dfs(grid, y, x - 1);
    }
}
