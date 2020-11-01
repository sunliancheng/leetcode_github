package LC0_200.LC50_100;

import LeetCodeUtils.MyMatrix;
import LeetCodeUtils.MyPrint;
import org.junit.Test;

import java.util.Arrays;

public class LC85_Maximal_Rectangle {

    @Test
    public void test() {
        System.out.println(maximalRectangle(MyMatrix.matrixAdapter("[[\"1\",\"0\",\"1\",\"0\",\"0\"],[\"1\",\"0\",\"1\",\"1\",\"1\"],[\"1\",\"1\",\"1\",\"1\",\"1\"],[\"1\",\"0\",\"0\",\"1\",\"0\"]]", 4, 5)));
    }

    public int maximalRectangle(char[][] matrix) {
        //MyPrint.print2DMatrix(matrix);
        if (matrix.length == 0) return 0;
        int max = 0;
        int len = matrix.length, wid = matrix[0].length;
        int[] width = new int[wid + 1];
        int[] hight = new int[wid + 1];

        for (int i = 0; i < len; ++i) {
            Arrays.fill(width, 0);
            for (int j = 0; j < wid; ++j) {
                width[j + 1] = matrix[i][j] == '0' ? 0 : width[j] + 1;
                hight[j + 1] = matrix[i][j] == '0' ? 0 : hight[j + 1] + 1;

                int k = 1, idx = j + 1, h = hight[j + 1];
                while (k <= width[j + 1]) {
                    h = Math.min(h, hight[idx]);
                    max = Math.max(max, h * k);
                    k++;
                    idx--;
                }
            }
        }
        return max;
    }
}
