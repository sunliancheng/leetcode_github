package LC200_400.LC250_300;

import org.junit.Test;

import java.util.PriorityQueue;

public class LC295_Find_Median_From_Data_Stream {
    @Test
    public void test() {
        MedianFinder medianFinder = new MedianFinder();
    }
}

class MedianFinder {

    PriorityQueue<Integer> max = null, min = null;

    /** initialize your data structure here. */
    public MedianFinder() {
        min = new PriorityQueue<>((Integer a, Integer b) -> a - b);
        max = new PriorityQueue<>((Integer a, Integer b) -> b - a);
    }

    public void addNum(int num) {
        min.add(num);
        max.add(min.remove());
        if (min.size() < max.size())
            min.add(max.remove());
    }

    public double findMedian() {
        if (min.size() == max.size())
            return (Double.valueOf(min.peek()) + max.peek()) / 2;
        else
            return Double.valueOf(min.peek());
    }
}
