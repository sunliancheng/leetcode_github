package LC0_200.LC50_100;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class LC56_Merge_Intervals {

    private class IntervalComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1;
        }
    }

    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> list = new LinkedList<int[]>();
        // sort
        Collections.sort(Arrays.asList(intervals), new IntervalComparator());
        // merge
        for (int[] merge : intervals) {
            if (list.isEmpty() || list.getLast()[1] < merge[0])
                list.add(merge);
            else
                list.getLast()[1] = list.getLast()[1] > merge[1] ? list.getLast()[1] : merge[1];
        }

        return list.toArray(new int[list.size()][]);
    }
}
