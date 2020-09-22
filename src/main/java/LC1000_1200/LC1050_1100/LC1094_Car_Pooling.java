package LC1000_1200.LC1050_1100;

import org.junit.Test;

import java.util.*;

/**
 *  2020-09-22 10:06 AM at Hangzhou
 */

public class LC1094_Car_Pooling {

    /**
     * You are driving a vehicle that has capacity empty seats initially available for passengers.
     * The vehicle only drives east (ie. it cannot turn around and drive west.)
     *
     * Given a list of trips, trip[i] = [num_passengers, start_location, end_location]
     * contains information about the i-th trip: the number of passengers that must be picked up,
     * and the locations to pick them up and drop them off.
     * The locations are given as the number of kilometers due east from your vehicle's initial location.
     *
     * Return true if and only if it is possible to pick up and drop off all passengers for all the given trips.
     *
     *
     * Example 1:
     *
     * Input: trips = [[2,1,5],[3,3,7]], capacity = 4
     * Output: false
     *
     * [[8,2,3],[4,1,3],[1,3,6],[8,4,6],[4,4,8]]
     * 12
     */


    public boolean carPooling(int[][] trips, int capacity) {

        int current_passengers = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        Collections.sort(Arrays.asList(trips), new MyComparator());

        int index = 0, i = 0, max = trips[0][2];

        while (index < trips.length && i <= max) {
            int flag = 0;
            max = max > trips[index][2] ? max : trips[index][2];
            if (map.containsKey(i))
                current_passengers -= map.get(i);

            while (index < trips.length && i == trips[index][1]) {
                current_passengers += trips[index][0];
                if (current_passengers > capacity)
                    return false;
                if (!map.containsKey(trips[index][2])) {
                    map.put(trips[index][2], trips[index][0]);
                } else
                    map.put(trips[index][2], map.get(trips[index][2]) + trips[index][0]);
                if (index < trips.length)
                    index++;
            }
            ++i;
        }
        return true;
    }

    private class MyComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[1] < o2[1] ? -1 : o1[1] == o2[1] ? 0 : 1;
        }
    }

    @Test
    public void test() {
        //System.out.println(carPooling(new int[][]{{8, 2, 3}, {4, 1, 3}, {1, 3, 6}, {8, 4, 6}, {4, 4, 8}}, 12));
        //System.out.println(carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 5));
        /**
         * [[9,3,4],[9,1,7],[4,2,4],[7,4,5]]
         * 23
         */
        System.out.println(carPooling(new int[][]{{9, 3, 4}, {9, 1, 7}, {4, 2, 4}, {7, 4, 5}}, 23));
    }
}
