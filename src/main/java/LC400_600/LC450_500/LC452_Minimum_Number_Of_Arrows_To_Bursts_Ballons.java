package LC400_600.LC450_500;

import java.util.Arrays;

public class LC452_Minimum_Number_Of_Arrows_To_Bursts_Ballons {

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0)
            return 0;
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int res = 1, minRight = points[0][1];
        for (int i = 1; i < points.length; ++i) {
            if (points[i][0] <= minRight) {
                minRight = Math.min(minRight, points[i][1]);
                continue;
            } else {
                minRight = points[i][1];
                res++;
            }
        }
        return res;
    }

    public int find(int[][] points) {
        if (points.length == 0)
            return 0;
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int res = 1, end = points[0][1];
        for (int i = 1; i < points.length; ++i) {
            if (points[i][0] <= end) {
                end = Math.min(end, points[i][1]);
                continue;
            } else {
                res++;
                end = points[i][1];
            }
        }
        return res;
    }

}
