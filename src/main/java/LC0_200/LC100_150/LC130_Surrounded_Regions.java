package LC0_200.LC100_150;

import LeetCodeUtils.MyMatrix;
import LeetCodeUtils.MyPrint;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LC130_Surrounded_Regions {

    @Test
    public void test() {
        String a = "[[\"X\",\"O\",\"O\",\"X\",\"X\",\"X\",\"O\",\"X\",\"O\",\"O\"],[\"X\",\"O\",\"X\",\"X\",\"X\",\"X\",\"X\",\"X\",\"X\",\"X\"],[\"X\",\"X\",\"X\",\"X\",\"O\",\"X\",\"X\",\"X\",\"X\",\"X\"],[\"X\",\"O\",\"X\",\"X\",\"X\",\"O\",\"X\",\"X\",\"X\",\"O\"],[\"O\",\"X\",\"X\",\"X\",\"O\",\"X\",\"O\",\"X\",\"O\",\"X\"],[\"X\",\"X\",\"O\",\"X\",\"X\",\"O\",\"O\",\"X\",\"X\",\"X\"],[\"O\",\"X\",\"X\",\"O\",\"O\",\"X\",\"O\",\"X\",\"X\",\"O\"],[\"O\",\"X\",\"X\",\"X\",\"X\",\"X\",\"O\",\"X\",\"X\",\"X\"],[\"X\",\"O\",\"O\",\"X\",\"X\",\"O\",\"X\",\"X\",\"O\",\"O\"],[\"X\",\"X\",\"X\",\"O\",\"O\",\"X\",\"O\",\"X\",\"X\",\"O\"]]";
        solve(MyMatrix.matrixAdapter(a, 10, 10));
    }

    //0 original status  1 reachable  2 not reachable
    Deque<int[]> queue = new LinkedList<>();
    int[] direction = new int[]{-1, 0, 1, 0, -1};
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;
        for (int i = 0; i < board.length; ++i) {
            if (board[i][0] == 'O') {
                queue.add(new int[]{i, 0});
                board[i][0] = 'K';
            }
            if (board[i][board[0].length - 1] == 'O') {
                queue.add(new int[]{i, board[0].length - 1});
                board[i][board[0].length - 1] = 'K';
            }

        }
        for (int i = 1; i < board[0].length - 1; ++i) {
            if (board[0][i] == 'O') {
                queue.add(new int[]{0, i});
                board[0][i] = 'K';
            }
            if (board[board.length - 1][i] == 'O') {
                queue.add(new int[]{board.length - 1, i});
                board[board.length - 1][i] = 'K';
            }
        }
        bfs(board);
        for (int i = 0; i < board.length; ++i)
            for (int j = 0; j < board[0].length; ++j)
                if (board[i][j] == 'K')
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';

    }

    void bfs(char[][] board) {
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0], y = point[1];

            for (int i = 0; i < 4; ++i) {
                int xx = x + direction[i], yy = y + direction[i + 1];
                if (xx >= 0 && xx < board.length && yy >= 0 && yy < board[0].length
                        && board[xx][yy] == 'O') {
                    queue.offer(new int[]{xx, yy});
                    board[xx][yy] = 'K';
                }
            }

        }
    }



}
