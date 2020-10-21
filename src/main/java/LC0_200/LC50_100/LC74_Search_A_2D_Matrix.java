package LC0_200.LC50_100;

import LeetCodeUtils.MyMatrix;
import LeetCodeUtils.MyPrint;
import org.junit.Test;

public class LC74_Search_A_2D_Matrix {

    @Test
    public void test() {
        System.out.println(searchMatrix(MyMatrix.IntMatrixAdapter("[[-10,-10],[-9,-9],[-8,-6],[-4,-2],[0,1],[3,3],[5,5],[6,8]]", 8, 2), 0));
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix[0].length == 0)
            return false;

        int low = 0, high = matrix.length - 1;
        int r = -1, c = -1;
        while (low < high) {
            if (low == high - 1) {
                if (matrix[low][0] <= target && matrix[low][matrix[0].length - 1] >= target)
                    r = low;
                else if (matrix[high][0] <= target && matrix[high][matrix[0].length - 1] >= target) {
                    r = high;
                }
                break;
            }
            int mid = (low + high) / 2;
            if (matrix[mid][0] > target) {
                high = mid;
                continue;
            } else if (matrix[mid][matrix[0].length - 1] < target) {
                low = mid;
                continue;
            } else {
                r = mid;
                break;
            }
        }
        if (r == -1) {
            r = low;
        }
        low = 0;
        high = matrix[0].length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (low == mid || mid == high) {
                if (matrix[r][low] == target)
                    c = low;
                else if (matrix[r][high] == target)
                    c = high;
                break;
            }
            if (matrix[r][mid] > target) {
                high = mid;
                continue;
            } else if (matrix[r][mid] < target){
                low = mid;
                continue;
            } else {
                c = mid;
                break;
            }

        }
        if (c == -1) {
            if (matrix[r][0] == target)
                return true;
        }
        if (r != -1 && c != -1)
            return true;
        return false;
    }

}
