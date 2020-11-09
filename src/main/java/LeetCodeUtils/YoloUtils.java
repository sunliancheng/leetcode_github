package LeetCodeUtils;

import LeetCodeUtils.LeetCode.Problem;
import org.junit.Test;
import org.omg.CosNaming.BindingIterator;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class YoloUtils {

    private static int ans = 0;

    @Test
    public void test() {
        System.out.println(init(MyMatrix.IntMatrixAdapter("[[1,0,0],[0,1,0],[0,0,1]]", 3, 3)));
    }

//    @Test
//    public void test() {
//        System.out.println(init(MyMatrix.IntMatrixAdapter("[[0,2,3,4,5,0,0,0,6,7],[1,0,3,4,5,6,0,5,0,0],[2,0,4,5,6,0,0,6,7,1],[0,0,0,0,0,0,0,0,8,9]]", 4, 10)));
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();

        int[][] matrix = new int[n][m];
        String line = sc.nextLine();
        for (int i = 0; i < n; ++i) {
            line = sc.nextLine();
            for (int j = 0; j < line.length(); ++j)
                matrix[i][j] = line.charAt(j) - '0';
        }
        System.out.println(init(matrix));
    }

    public static int init(int[][] m) {
        boolean[][] isUsed = new boolean[m.length][m[0].length];
        MyPrint.print2DMatrix(m);

        for (int i = 0; i < m.length; ++i) {
            for (int j = 0; j < m[0].length; ++j) {
                if (m[i][j] != 0 && isUsed[i][j] != true) {
                    dfs(i, j, m, isUsed);
                    ans++;
                }
            }
        }
        MyPrint.print2DMatrix(isUsed);
        return ans;
    }

    public static void dfs(int i, int j, int[][] m, boolean[][] isUsed) {

        if (i < 0 || i >= m.length || j < 0 || j >= m[0].length)
            return;

        if (isUsed[i][j])
            return;

        if (m[i][j] != 0) {
            isUsed[i][j] = true;
            dfs(i + 1, j, m, isUsed);
            dfs(i - 1, j, m, isUsed);
            dfs(i, j + 1, m, isUsed);
            dfs(i, j - 1, m, isUsed);
        }
    }



    /**
     * 4 10
     * 0234500067
     * 1034560500
     * 2045600671
     * 0000000089
     */
}
