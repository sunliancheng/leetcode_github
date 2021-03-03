package LC200_400.LC200_250;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LC212_Word_Search2 {

    @Test
    public void test() {
        char[][] board = new char[][]{{'a','a'}};
        String[] words = new String[]{"aa"};
        findWords(board, words);
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            boolean flag = false;
            for (int i = 0; i < board.length; ++i) {
                if (flag) break;
                for (int j = 0; j < board[0].length; ++j) {
                    if (dfs(i, j, word, 0, new boolean[board.length][board[0].length], board)) {
                        result.add(word);
                        flag = true;
                        break;
                    }
                }
            }
        }
        return result;
    }

    public boolean dfs(int i, int j, String word, int idx, boolean[][] isVisted, char[][] board) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if (word.charAt(idx) != board[i][j] || isVisted[i][j]) return false;
        if (idx == word.length() - 1) return true;
        isVisted[i][j] = true;
        return dfs(i - 1, j, word, 1 + idx, isVisted, board)
                || dfs(i + 1, j, word, 1 + idx, isVisted, board)
                || dfs(i, j + 1, word, 1 + idx, isVisted, board)
                || dfs(i, j - 1, word, 1 + idx, isVisted, board);
    }

}
