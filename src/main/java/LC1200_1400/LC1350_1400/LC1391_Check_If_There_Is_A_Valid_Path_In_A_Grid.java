package LC1200_1400.LC1350_1400;

public class LC1391_Check_If_There_Is_A_Valid_Path_In_A_Grid {
    private boolean dfs(int i, int j, int[][] grid, int m, int n, int p, boolean[][] v ){
        // p represents the previous direction permitted direction
        if(i<0||j<0||i>=m||j>=n||v[i][j])
            return false;

        boolean[] dir = streets[grid[i][j]-1];
        if(!(i==0 && j==0) && !dir[p]) // check whether if the street is permitted from previous direction, except for the starting point
            return false;

        if(i==m-1 && j==n-1)
            return true;
        v[i][j] = true;
        if(dir[0] && dfs(i-1,j,grid,m,n,2,v)){ // for top permitted direction of 2(bottom) similarly for others as well.
            return true;
        }
        if(dir[1] && dfs(i,j+1,grid,m,n,3,v)){
            return true;
        }
        if(dir[2] && dfs(i+1,j,grid,m,n,0,v)){
            return true;
        }
        if(dir[3] && dfs(i,j-1,grid,m,n,1,v)){
            return true;
        }
        v[i][j]=false;
        return false;
    }
    // create a mapping of permitted directions of the 4 streets. Each index represent a direction. 0 -> top, 1-> right, 2->down, 3-> left in clockwise directions.
    boolean[][] streets = new boolean[][]{{false, true, false, true},
            {true, false, true, false},
            {false, false, true, true},
            {false, true, true, false},
            {true, false, false, true},
            {true, true, false, false}};

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        return dfs(0,0,grid,m,n,0, visited);
    }
}
