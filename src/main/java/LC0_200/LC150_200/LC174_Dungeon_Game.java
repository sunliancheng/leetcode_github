package LC0_200.LC150_200;

import LeetCodeUtils.MyMatrix;
import LeetCodeUtils.MyPrint;
import org.junit.Test;

public class LC174_Dungeon_Game {

    @Test
    public void test() {
        int[][] d = MyMatrix.IntMatrixAdapter("[[0,-74,-47,-20,-23,-39,-48],[37,-30,37,-65,-82,28,-27],[-76,-33,7,42,3,49,-93],[37,-41,35,-16,-96,-56,38],[-52,19,-37,14,-65,-42,9],[5,-26,-30,-65,11,5,16],[-60,9,36,-36,41,-47,-86],[-22,19,-5,-41,-8,-96,-95]]", 8, 7);
        int[][] v = MyMatrix.IntMatrixAdapter("[[-2,-3,3],[-5,-10,1],[10,30,-5]]", 3,3);
        System.out.println(calculateMinimumHP(v));
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int[][] memory = new int[dungeon.length][dungeon[0].length];
        int ans = dfs(dungeon, 0, 0, memory);
        return 1 + ans;
    }

    public int dfs(int[][] board, int i, int j, int[][] memory) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return Integer.MAX_VALUE;
        if (memory[i][j] != 0) return memory[i][j];

        if (i == board.length - 1 && j == board[0].length - 1) {
            memory[i][j] = -board[i][j] > 0 ? -board[i][j] : 0;
            return memory[i][j];
        }

        int t = Math.min(dfs(board, i + 1, j, memory), dfs(board, i, j + 1, memory)) - board[i][j];
        memory[i][j] = t > 0 ? t : 0;
        return memory[i][j];
    }
}
