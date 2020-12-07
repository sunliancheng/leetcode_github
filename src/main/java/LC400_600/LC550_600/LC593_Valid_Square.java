package LC400_600.LC550_600;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LC593_Valid_Square {

    @Test
    public void test() {
        System.out.println(validSquare(new int[]{1,1}, new int[]{0,0}, new int[]{0,0}, new int[]{0,0}));
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        boolean ans = true;
        int[][] collec = new int[][]{p1, p2, p3, p4};

        // sort and choose the two points within which there distance is largest
        Arrays.sort(collec, (o1, o2) -> {
            if (o1[0] == o2[0])
                return o1[1] - o2[1];
            else
                return o1[0] - o2[0];
        });
        // find another two vectors and validate
        double[] v1 = new double[]{collec[0][0] - collec[1][0], collec[0][1] - collec[1][1]};
        double[] v2 = new double[]{collec[0][0] - collec[2][0], collec[0][1] - collec[2][1]};
        double[] v3 = new double[]{collec[1][0] - collec[3][0], collec[1][1] - collec[3][1]};
        double[] v4 = new double[]{collec[2][0] - collec[3][0], collec[2][1] - collec[3][1]};

        if (isVerticle(v1, v2) && isVerticle(v1, v3) && isVerticle(v2, v4)) {
            if (!((v1[0] == 0 && v1[1] == 0) || (v2[0] == 0 && v2[1] == 0) || (v3[0] == 0 && v3[1] == 0) || (v4[0] == 0 && v4[1] == 0))) {
                if (isSameDis(v1, v2)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isSameDis(double[] v1, double[] v2) {
        return v1[0] * v1[0] + v1[1] * v1[1] == v2[0] * v2[0] + v2[1] * v2[1];
    }

    public boolean isVerticle(double[] o1, double[] o2) {
        if (o1[0] * o2[0] + o1[1] * o2[1] == 0)
            return true;
        return false;
    }

}
