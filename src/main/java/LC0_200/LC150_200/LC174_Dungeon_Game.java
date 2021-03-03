package LC0_200.LC150_200;

import LeetCodeUtils.MyMatrix;
import LeetCodeUtils.MyPrint;
import org.junit.Test;

public class LC174_Dungeon_Game {

    @Test
    public void test() {
        int[][] d = MyMatrix.IntMatrixAdapter("[[0,-74,-47,-20,-23,-39,-48],[37,-30,37,-65,-82,28,-27],[-76,-33,7,42,3,49,-93],[37,-41,35,-16,-96,-56,38],[-52,19,-37,14,-65,-42,9],[5,-26,-30,-65,11,5,16],[-60,9,36,-36,41,-47,-86],[-22,19,-5,-41,-8,-96,-95]]", 8, 7);
        System.out.println(calculateMinimumHP(d));
    }

    int result = Integer.MAX_VALUE, initialBlood = 0, left = 0;

    public int calculateMinimumHP(int[][] dungeon) {
        MyPrint.print2DMatrix(dungeon);
        dfs(dungeon, 0, 0, new boolean[dungeon.length][dungeon[0].length]);
        return 1 + result;
    }

    public void dfs(int[][] board, int i, int j, boolean[][] visited) {
        if (i <0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]) return;
        int ori_init = initialBlood, ori_left = left;
        left = left + board[i][j]; initialBlood = initialBlood < left ? initialBlood : left;
        visited[i][j] = true;

        if (i == board.length - 1 && j == board[0].length - 1) {
            MyPrint.print2DMatrix(visited);
            result = result > -initialBlood ? -initialBlood : result;
            initialBlood = ori_init; left = ori_left; visited[i][j] = false;
            return;
        }

        dfs(board, i + 1, j, visited);
        dfs(board, i - 1, j, visited);
        dfs(board, i, j + 1, visited);
        dfs(board, i, j - 1, visited);
        initialBlood = ori_init; left = ori_left; visited[i][j] = false;
    }
}
