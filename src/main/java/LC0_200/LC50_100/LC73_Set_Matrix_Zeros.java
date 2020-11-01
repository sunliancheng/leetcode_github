package LC0_200.LC50_100;

import LeetCodeUtils.MyMatrix;
import LeetCodeUtils.MyPrint;
import org.junit.Test;

public class LC73_Set_Matrix_Zeros {

    @Test
    public void test() {
        setZeroes(MyMatrix.IntMatrixAdapter("[[-1],[2],[3]]", 3, 1));
    }


    public void setZeroes(int[][] matrix) {
        MyPrint.print2DMatrix(matrix);

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j)
                if (matrix[i][j] == 0)
                    setRC(matrix, i, j, Integer.MIN_VALUE + 1);
        }
        MyPrint.print2DMatrix(matrix);
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j)
                if (matrix[i][j] == Integer.MIN_VALUE + 1)
                    matrix[i][j] = 0;
        }
        MyPrint.print2DMatrix(matrix);

    }

    public void setRC(int[][] matrix, int i, int j, int num) {
        int m = matrix.length, n = matrix[0].length, len = m > n ? m : n;
        for (int l = 0; l < len; ++l) {
            if (l < m)
                if (matrix[l][j] != 0)
                    matrix[l][j] = num;
            if (l < n)
                if (matrix[i][l] != 0)
                    matrix[i][l] = num;
        }
    }


}
