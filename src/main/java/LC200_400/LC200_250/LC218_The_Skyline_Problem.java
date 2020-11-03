package LC200_400.LC200_250;

import LeetCodeUtils.MyMatrix;
import LeetCodeUtils.MyPrint;
import org.junit.Test;

import java.util.*;

public class LC218_The_Skyline_Problem {

    @Test
    public void test() {
        getSkyline(MyMatrix.IntMatrixAdapter("[[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]", 5 ,3));
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0)
            return result;

        List<int[]> height = new ArrayList<>();

        for (int[] building : buildings) {
            height.add(new int[]{building[0], 0 - building[2]});
            height.add(new int[]{building[1], building[2]});
        }

        Collections.sort(height, (a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            else
                return a[0] - b[0];
        });

        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a); //max heap
        queue.add(0);
        int preMaxHeight = 0;

        for (int[] point : height) {
            if (point[1] < 0)
                queue.add(0 - point[1]);
            else
                queue.remove(point[1]);

            int currMaxHeight = queue.peek();
            if (preMaxHeight != currMaxHeight) {
                result.add(new ArrayList<>(Arrays.asList(point[0], currMaxHeight)));
                preMaxHeight = currMaxHeight;
            }
        }
        return result;

    }
}
