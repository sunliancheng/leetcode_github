package LC200_400.LC250_300;

import LeetCodeUtils.MyPrint;

public class LC289_Game_Of_Life {

    public void gameOfLife(int[][] board) {

        for (int i = 0; i < board.length; ++i)
            for (int j = 0; j < board[0].length; ++j)
                findLiveAroundIt(board, i, j);

        for (int i = 0; i < board.length; ++i)
            for (int j = 0; j < board[0].length; ++j)
                if (board[i][j] == 2) board[i][j] = 0;
                else if (board[i][j] == -1) board[i][j] = 1;
    }

    public int findLiveAroundIt(int [][] board, int i, int j) {
        int count = 0;
        if (check(i - 1, j - 1, board) && board[i - 1][j - 1] > 0) count++;
        if (check(i + 1, j - 1, board) && board[i + 1][j - 1] > 0) count++;
        if (check(i - 1, j + 1, board) && board[i - 1][j + 1] > 0) count++;
        if (check(i + 1, j + 1, board) && board[i + 1][j + 1] > 0) count++;
        if (check(i - 1, j, board) && board[i - 1][j] > 0) count++;
        if (check(i + 1, j, board) && board[i + 1][j] > 0) count++;
        if (check(i, j - 1, board) && board[i][j - 1] > 0) count++;
        if (check(i, j + 1, board) && board[i][j + 1] > 0) count++;

        if (board[i][j] == 0)
            if (count == 3) board[i][j] = -1;
        else
            if (count < 2 || count > 3)
                board[i][j] = 2;

        return count;
    }

    public boolean check(int i, int j, int[][] b) {
        if (i < 0 || j < 0 || i >= b.length || j >= b[0].length)
            return false;
        return true;
    }

}
