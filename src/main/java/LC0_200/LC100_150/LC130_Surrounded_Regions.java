package LC0_200.LC100_150;

import LeetCodeUtils.MyMatrix;
import LeetCodeUtils.MyPrint;
import org.junit.Test;

import java.util.Stack;

public class LC130_Surrounded_Regions {

    @Test
    public void test() {
        solve(MyMatrix.matrixAdapter("[[X,X,X,X],[X,0,0,X],[X,X,0,X],[X,0,X,X]", 4, 4));
    }

    //0 original status  1 reachable  2 not reachable
    int[][] m;
    Stack<int[]> stack = new Stack<>();
    boolean flag = false;

    public void solve(char[][] board) {

        if (board.length == 0) {
            return;
        }

        m = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                flag = false;
                dfs(i, j, board);
                int tem = 2;
                if (!flag) {
                    for (int[] n : stack) {
                        board[n[0]][n[1]] = 'X';
                    }
                }
                stack.clear();
            }
        }

    }

    private void dfs(int i, int j, char[][] board) {

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return;
        if (board[i][j] == 'X')
            return;

        if (m[i][j] == 1) {
            return;
        }
        if (m[i][j] == 2) {

        }

        m[i][j] = 1;
        stack.push(new int[]{i, j});

        if (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) {
            flag = true;
        }


        dfs(i + 1, j, board);
        dfs(i, j + 1, board);
        dfs(i - 1, j, board);
        dfs(i, j - 1, board);
    }


}
