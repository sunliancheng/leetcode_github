package LC0_200.LC100_150;

import LeetCodeUtils.MyMatrix;
import LeetCodeUtils.MyPrint;
import org.junit.Test;

import java.util.HashMap;

public class LC149_Max_Points_On_A_Line {

    @Test
    public void test() {
        System.out.println(maxPoints(MyMatrix.
                IntMatrixAdapter("[[4,0],[4,1],[4,5]]",3, 2)));
    }


    public int maxPoints(int[][] points) {

        HashMap<Double, Integer> map = new HashMap<>();
        int max_count = 0, same = 1, same_y = 1;
        for (int i = 0; i < points.length; ++i) {
            same = 1; same_y = 1;
            for (int j = i + 1; j < points.length; ++j) {
                if (points[i][1] == points[j][1]) {
                    ++same_y; // y is same, find the number of nodes that on the same y
                    if (points[i][0] == points[j][0])
                        ++same;
                } else {
                    Double dx = Double.valueOf(points[i][0] - points[j][0]), dy = Double.valueOf(points[i][1] - points[j][1]);
                    if (map.containsKey(dx / dy))
                        map.put(dx / dy, map.get(dx / dy) + 1);
                    else
                        map.put(dx / dy, 1);
                }

            }
            max_count = Math.max(max_count, same_y);
            for (Integer d : map.values())
                max_count = Math.max(max_count, same + d);
            map.clear();
        }

        return max_count;
    }

}
