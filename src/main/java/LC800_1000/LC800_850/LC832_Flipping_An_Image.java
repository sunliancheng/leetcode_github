package LC800_1000.LC800_850;

import LeetCodeUtils.MyMatrix;
import LeetCodeUtils.MyPrint;
import org.junit.Test;

public class LC832_Flipping_An_Image {

    @Test
    public void test() {
        flipAndInvertImage(MyMatrix.IntMatrixAdapter("[[1,1,0],[1,0,1],[0,0,0]]", 3, 3));
    }

    public int[][] flipAndInvertImage(int[][] A) {
        for (int[] line : A) {
            int len = line.length;
            for (int i = 0; i < len; ++i) {
                int tem = len - 1 - i;
                if (i < tem) {
                    line[i] ^= line[tem];
                    line[tem] ^= line[i];
                    line[i] ^= line[tem];
                }
                line[i] ^= 1;
            }
        }
        return A;
    }

}
