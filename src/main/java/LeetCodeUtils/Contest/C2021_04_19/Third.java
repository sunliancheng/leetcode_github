package LeetCodeUtils.Contest.C2021_04_19;

import LeetCodeUtils.MyMatrix;
import org.junit.Test;

import java.util.*;
import java.util.PriorityQueue;

public class Third {

    @Test
    public void test() {
        getOrder(MyMatrix.IntMatrixAdapter("[[19,13],[16,9],[21,10],[32,25],[37,4],[49,24],[2,15],[38,41],[37,34],[33,6],[45,4],[18,18],[46,39],[12,24]]", 14, 2));
    }

    public int[] getOrder(int[][] tasks) {
        Map<int[], List<Integer>> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a, b) -> {
            if (a[1] == b[1]) {
                return map.get(a).get(0) - map.get(b).get(0);
            } else return a[1] - b[1];
        } );
        int[] result = new int[tasks.length];
        int n = tasks.length;
        for (int i = 0; i < tasks.length; ++i) {
            map.computeIfAbsent(tasks[i], x -> new ArrayList<>()).add(i);
        }

        int next_finish = 0, next_start = 1, time = 1, taskIdx = 0, resultIdx = 0;
        Arrays.sort(tasks, (a, b) -> a[0] - b[0]);

        while (true) {
            while (taskIdx < n && time >= tasks[taskIdx][0]) {
                pq.add(tasks[taskIdx]);
                taskIdx++;
                //next_start =
            }
            if (pq.size() > 0) {
                int[] peek = pq.poll();
                result[resultIdx++] = map.get(peek).get(0);
                map.get(peek).remove(0);
                next_finish = time + peek[1] - 1;
            } else {
                next_finish = tasks[taskIdx][0] - 1;
            }
            time = 1 + next_finish;

            if (pq.size() == 0 && taskIdx >= tasks.length) break;
        }

        return result;
    }

}
