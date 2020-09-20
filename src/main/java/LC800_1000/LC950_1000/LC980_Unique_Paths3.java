package LC800_1000.LC950_1000;

/**
 *  2020-09-20 7:13 PM at Hangzhou
 */
public class LC980_Unique_Paths3 {

    int rows, cols;
    int[][] grid;
    int path_count;

    public int uniquePathsIII(int[][] grid) {
        int non_obstacles = 0, start_row = 0, start_col = 0;
        this.rows = grid.length; this.cols = grid[0].length;
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                int cell = grid[row][col];
                if (cell >= 0)
                    non_obstacles += 1;
                if (cell == 1) {
                    start_row = row;
                    start_col = col;
                }
            }
        }
        this.path_count = 0;
        this.grid = grid;
        backtrack(start_row, start_col, non_obstacles);
        return this.path_count;
    }

    public void backtrack(int row, int col, int remain) {
        if (this.grid[row][col] == 2 && remain == 1) {
            this.path_count += 1;
            return;
        }
        int temp = grid[row][col];
        grid[row][col] = -4;
        remain -= 1;
        int[] row_offsets = {0, 0, 1, -1}, col_offsets = {1, -1, 0, 0};
        for (int i = 0; i < 4; ++i) {
            int next_row = row + row_offsets[i], next_col = col + col_offsets[i];
            if (0 > next_row || next_row >= this.rows || 0 > next_col || next_col >= this.cols)
                continue;
            if (grid[next_row][next_col] < 0)
                continue;
            backtrack(next_row, next_col, remain);
        }
        grid[row][col] = temp;
    }

}
