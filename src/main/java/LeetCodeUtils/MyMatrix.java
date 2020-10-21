package LeetCodeUtils;

import org.junit.Test;

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

    public static char[][] matrixAdapter(String s, int n) {
        char[][] result = new char[n][n];
        String[] ss = s.split("]");
        int i = 0;
        for (String in : ss) {
            if (in.length() != 0 && in != null && !in.equals("\n")) {
                String finl = in.substring(2);
                int j = 0;
                String[] h = finl.split(",");
                for (String hs : h) {
                    String res = hs.replace('"', ' ').trim();
                    result[i][j++] = res.charAt(0);
                }
                i++;
            }
        }
        return result;
    }

    public static int[][] IntMatrixAdapter(String s, int m, int n) {
        int[][] result = new int[m][n];
        String[] ss = s.split("]");
        int i = 0;
        for (String in : ss) {
            if (in.length() != 0 && in != null && !in.equals("\n")) {
                String finl = in.substring(2);
                int j = 0;
                String[] h = finl.split(",");
                for (String hs : h) {
                    String res = hs.replace('"', ' ').trim();
                    result[i][j++] = Integer.valueOf(res);
                }
                i++;
            }
        }
        return result;
    }

    public static char[][] copyMatrix(char[][] m) {
        char[][] res = new char[m.length][m[0].length];
        for (int i = 0; i < m.length; ++i) {
            for (int j = 0; j < m.length; ++j) {
                res[i][j] = m[i][j];
            }
        }
        return res;
    }

    @Test
    public void test() {
        String s = "[[\"8\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]\n";

        MyPrint.print2DMatrix(matrixAdapter(s, 9));
    }

}
