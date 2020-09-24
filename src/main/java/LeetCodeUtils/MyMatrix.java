package LeetCodeUtils;

public class MyMatrix {

    public static void setMatrixANumber(int re, int[][] m) {
        for (int i = 0; i < m.length; ++i)
            for (int j = 0; j < m[0].length; ++j)
                m[i][j] = re;
    }

    public static void setMatrixANumber(boolean re, boolean[][] m) {
        for (int i = 0; i < m.length; ++i)
            for (int j = 0; j < m[0].length; ++j)
                m[i][j] = re;
    }
}
