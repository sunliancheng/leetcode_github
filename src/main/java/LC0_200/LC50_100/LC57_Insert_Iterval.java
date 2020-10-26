package LC0_200.LC50_100;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class LC57_Insert_Iterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> list = new LinkedList<int[]>();
        // sort
        int[][] inter = new int[intervals.length + 1][];
        for (int i = 0; i < intervals.length; ++i)
            inter[i] = intervals[i];
        inter[intervals.length] = newInterval;
        Collections.sort(Arrays.asList(inter), new IntervalComparator());
        // merge
        for (int[] merge : inter) {
            if (list.isEmpty() || list.getLast()[1] < merge[0])
                list.add(merge);
            else
                list.getLast()[1] = list.getLast()[1] > merge[1] ? list.getLast()[1] : merge[1];
        }
        return list.toArray(new int[list.size()][]);
    }

    private class IntervalComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1;
        }
    }
}
