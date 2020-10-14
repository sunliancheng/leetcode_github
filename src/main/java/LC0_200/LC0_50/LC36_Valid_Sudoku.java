package LC0_200.LC0_50;

import LeetCodeUtils.MyMatrix;
import org.junit.Test;

public class LC36_Valid_Sudoku {

    boolean[][] col = new boolean[9][9], row = new boolean[9][9], nine = new boolean[9][9];

    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.')
                    continue;
                else {
                    if (check(i, j, board[i][j] - '1')) {
                        col[j][board[i][j] - '1'] = true;
                        row[i][board[i][j] - '1'] = true;
                        nine[calNine(i, j)][board[i][j] - '1'] = true;
                        continue;
                    }
                    else
                        return false;
                }
            }
        }
        return true;
    }


    public boolean check(int i, int j, int val) {
        if (!row[i][val] && !col[j][val] && !nine[calNine(i, j)][val])
            return true;
        return false;
    }

    public int calNine(int i, int j) {
        int r = 0, c = 0;
        if (i >= 0 && i < 3)
            r = 0;
        else if (i >= 3 && i < 6)
            r = 1;
        else
            r = 2;

        if (j >= 0 && j < 3)
            c = 0;
        else if (j >= 3 && j < 6)
            c = 1;
        else
            c = 2;

        return 3 * r + c;
    }

    public void dfs(char[][] board) {



    }

    @Test
    public void test() {
        String s = "[[\"8\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]\n";
        System.out.println(isValidSudoku(MyMatrix.matrixAdapter(s, 9)));;
    }

}
