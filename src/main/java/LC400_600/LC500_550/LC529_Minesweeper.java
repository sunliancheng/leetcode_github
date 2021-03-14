package LC400_600.LC500_550;

import LeetCodeUtils.MyMatrix;
import org.junit.Test;

public class LC529_Minesweeper {

    @Test
    public void test() {

    }

    int[][] directions = new int[][] {{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0},{1,1}};

    public char[][] updateBoard(char[][] board, int[] click) {

        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        } else if (board[click[0]][click[1]] == 'E') {
            int cou = checkNull(board, click[0], click[1]);
            if (cou == 0) {
                // B
                board[click[0]][click[1]] = 'B';
                for (int[] dir : directions) {
                    if (!checkValid(board.length, board[0].length, click[0] + dir[0], click[1] + dir[1])) continue;
                    updateBoard(board, new int[]{click[0] + dir[0], click[1] + dir[1]});
                }
            } else {
                // digit
                board[click[0]][click[1]] = (char) ('0' + cou);
            }
        }
        return board;
    }

    public int checkNull(char[][] board, int i, int j) {
        int count = 0;
        //int[][] directions = new int[][] {{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0},{1,1}};
        for (int[] dir : directions) {
            if (!checkValid(board.length, board[0].length, i + dir[0], j + dir[1])) continue;
            if (board[i + dir[0]][j + dir[1]] == 'M') ++count;
        }
        return count;
    }

    public boolean checkValid(int m, int n, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n)
            return false;
        return true;
    }


}
