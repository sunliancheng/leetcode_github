package LC0_200.LC0_50;

import LeetCodeUtils.MyMatrix;
import LeetCodeUtils.MyPrint;
import org.junit.Test;

/**
 * 2020-10-14 at Hangzhou
 */
public class LC37_Sudoku_Solver {

    boolean[][] col = new boolean[9][9], row = new boolean[9][9], nine = new boolean[9][9];
    boolean fl = false;

    public void solveSudoku(char[][] board) {

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.')
                    continue;
                if (check(i, j, board[i][j] - '1')) {
                    col[j][board[i][j] - '1'] = true;
                    row[i][board[i][j] - '1'] = true;
                    nine[calNine(i, j)][board[i][j] - '1'] = true;
                }
            }
        }
        dfs(board, 0, 0);
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

    public void dfs(char[][] board, int i, int j) {

        if (i > 8) {
            fl = true;
            return;
        }

        if (board[i][j] == '.') {
            for (int val = 0; val < 9; ++val) {
                if (check(i, j, val)) {
                    col[j][val] = true;
                    row[i][val] = true;
                    nine[calNine(i, j)][val] = true;
                    board[i][j] = (char) (val + '1');

                    if (j < 8)
                        dfs(board, i, j + 1);
                    else
                        dfs(board, i + 1, 0);

                    if (!fl) {
                        col[j][val] = false;
                        row[i][val] = false;
                        nine[calNine(i, j)][val] = false;
                        board[i][j] = '.';
                    }
                }
            }
        } else {
            if (j < 8)
                dfs(board, i, j + 1);
            else
                dfs(board, i + 1, 0);
        }
    }

    @Test
    public void test() {
        String s = "[[\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]";
        //String s = "[[\"8\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]\n";
        MyPrint.print2DMatrix(MyMatrix.matrixAdapter(s, 9));
        solveSudoku(MyMatrix.matrixAdapter(s, 9));
    }
}
