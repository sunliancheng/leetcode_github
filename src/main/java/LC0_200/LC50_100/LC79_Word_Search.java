package LC0_200.LC50_100;

import LeetCodeUtils.MyMatrix;
import LeetCodeUtils.MyPrint;
import org.junit.Test;

public class LC79_Word_Search {

    @Test
    public void test() {
        System.out.println(exist(MyMatrix.matrixAdapter("[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]", 3, 4), "SEED"));
    }

    int index = 0;
    String word = "";
    boolean[][] m;

    public boolean exist(char[][] board, String word) {

        m = new boolean[board.length][board[0].length];
        this.word = word;

        for (int i = 0; i < board.length; ++i)
            for (int j = 0; j < board[0].length; ++j)
                if (board[i][j] == word.charAt(0) && dfs(board, i, j))
                    return true;
        return false;
    }

    public boolean dfs(char[][] board, int i, int j) {
        if (index >= word.length() || i < 0 || j < 0|| i >= board.length || j >= board[0].length)
            return false;
        if (board[i][j] == word.charAt(index) && !m[i][j]) {
            m[i][j] = true;
            if (index == word.length() - 1)
                return true;
            index++;
        } else
            return false;

        boolean ans = dfs(board, i + 1, j) || dfs(board, i - 1, j) || dfs(board, i, j + 1) || dfs(board, i, j - 1);
        index--;
        m[i][j] = false;
        return ans;
    }

}
