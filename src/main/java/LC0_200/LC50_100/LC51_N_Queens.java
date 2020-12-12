package LC0_200.LC50_100;

import LeetCodeUtils.MyPrint;

import org.junit.Test;

import java.util.*;

/**
 * 2020-09-25 11:24 PM at Hangzhou
 */
public class LC51_N_Queens {


    private List<List<String>> res = new ArrayList<>();
    boolean[] r, c, d1, d2;
    public List<List<String>> solveNQueens(int n) {
        c = new boolean[n];
        d1 = new boolean[2 * n]; // d1 = r - c + n
        d2 = new boolean[2 * n]; // d2 = r + c

        char[][] board = new char[n][n];
        for (int i = 0; i < n; ++i) {
            board[i] = new char[n];
            for (int j = 0; j < n; ++j)
                board[i][j] = '.';
        }
        backtracking(board, 0, n);

//        for (List<String> s : res) {
//
//            for (String ss : s)
//                System.out.print(ss.toString() + " ");
//            System.out.println();
//        }
        return res;
    }

    void backtracking(char[][] board, int row, int n) {
        if (row == n) {
            List<String> tem = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; ++j)
                    sb.append(board[i][j]);
                tem.add(sb.toString());
            }

            res.add(tem);
            return;
        }

        for (int i = 0; i < n; ++i) {
            if (c[i] || d1[row - i + n] || d2[row + i])
                continue;
            board[row][i] = 'Q';
            c[i] = d1[row - i + n] = d2[row + i] = true;

            backtracking(board, row + 1, n);

            board[row][i] = '.';
            c[i] = d1[row - i + n] = d2[row + i] = false;

        }

    }


    @Test
    public void test() {
        System.out.println(solveNQueens(4));
    }


}
