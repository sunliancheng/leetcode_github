package LC0_200.LC50_100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC52_N_Queens2 {

    boolean[] _c,_d1,_d2;
    int result = 0;

    public int totalNQueens(int n) {
        _c = new boolean[n];
        _d1 = new boolean[2 * n];
        _d2 = new boolean[2 * n];
        recursive(0, n);
        return result;
    }

    public void recursive(int i, int n) {
        if (i == n) {
            ++result;
            return;
        }
        for (int j = 0; j < n; ++j) {
            int tem = i + j, temp = i - j + n;
            if (!_c[j] && !_d1[tem] && !_d2[temp]) {
                _c[j] = _d1[tem] = _d2[temp] = true;
                int ii = i + 1;
                recursive(ii, n);
                _c[j] = _d1[tem] = _d2[temp] = false;
            }
        }
    }

    @Test
    public void test() {
        System.out.println(totalNQueens(4));
    }
}

/**
 *  The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *  Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 *
 * Example:
 *
 * Input: 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 */
