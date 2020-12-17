package LC200_400.LC200_250;

public class LC240_Search_A_2D_Matrix2 {



    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        int i = 0, j = matrix[0].length - 1;
        return f(i, j, matrix, target);
    }

    private boolean f(int i, int j, int[][] m, int target) {
        if (i >= m.length || j < 0)
            return false;
        if (m[i][j] == target)
            return true;
        if (m[i][j] > target)
            return f(i, j + 1, m, target);
        else
            return f(i + 1, j, m, target);
    }

}
