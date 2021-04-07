package LC600_800.LC700_750;

import java.util.Stack;

public class LC733_Flood_Fill {

    public int[] directions = new int[]{1, 0, -1, 0, 1};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Stack<int[]> stack = new Stack<>();
        dfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    public void dfs(int[][] img, int sr, int sc, int newColor, int ori) {
        if (sr < 0 || sc < 0 || sr >= img.length || sc >= img[0].length || ori == newColor || ori != img[sr][sc]) return;
        img[sr][sc] = newColor;
        for (int i = 0; i < directions.length - 1; ++i)
            dfs(img, sr + directions[i], sc + directions[i + 1], newColor, ori);
    }
}
