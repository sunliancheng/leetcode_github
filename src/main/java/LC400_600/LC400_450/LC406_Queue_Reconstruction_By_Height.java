package LC400_600.LC400_450;

import LeetCodeUtils.MyMatrix;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC406_Queue_Reconstruction_By_Height {

    @Test
    public void test() {
        System.out.println(reconstructQueue(MyMatrix.IntMatrixAdapter
                ("[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]", 6, 2)));
    }



    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            return b[0] - a[0];
        });

        List<int[]> res = new LinkedList<>();
        res.add(people[0]);

        for (int i = 1; i < people.length; ++i) {
            int times = people[i][1], num = people[i][0];
            for (int j = 0; j < res.size(); ++j) {
                if (num <= res.get(j)[0] && times > 0) {
                    if (--times <= 0) {
                        res.add(++j, people[i]);
                        break;
                    }
                } else if (num <= res.get(j)[0] && times == 0) {
                    res.add(0, people[i]);
                    break;
                }

            }
        }

        int[][] result = res.toArray(new int[0][]);
        return result;
    }

    /**
     * You are given an array of people, people,
     * which are the attributes of some people in a queue (not necessarily in order).
     * Each people[i] = [hi, ki] represents the ith person of height hi
     * with exactly ki other people in front who have a height greater than or equal to hi.
     *
     * Reconstruct and return the queue that is represented by the input array people.
     * The returned queue should be formatted as an array queue,
     * where queue[j] = [hj, kj] is the attributes of the jth person in the queue
     * (queue[0] is the person at the front of the queue).
     */

}
