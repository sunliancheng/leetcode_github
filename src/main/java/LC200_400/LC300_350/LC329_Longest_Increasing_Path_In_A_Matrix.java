package LC200_400.LC300_350;

public class LC329_Longest_Increasing_Path_In_A_Matrix {
    public final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) return 0;
        //m 行数 n列数
        int m = matrix.length; int n = matrix[0].length;
        int[][] cache = new int[m][n];
        int max = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                max = Math.max(max, dfs(matrix, i, j, m, n, cache));
            }
        }
        return max;
    }

    public int dfs(int[][] matrix, int i, int j, int m, int n, int[][] cache){
        //I forget to restore the previous result of dfs[i][j]
        if(cache[i][j] != 0) return cache[i][j];
        int max = 1;
        for(int[] dir : dirs){
            int x = i + dir[0]; int y = j + dir[1];
            //数组中的行列和xy不一致
            if(x < 0 || x >= m || y < 0 || y >= n || matrix[i][j] >= matrix[x][y]) continue;
            int len = dfs(matrix, x, y, m, n, cache) + 1;
            max = Math.max(len, max);
        }
        cache[i][j] = max;
        return max;
    }
}
