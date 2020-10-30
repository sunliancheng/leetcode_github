package LC200_400.LC200_250;

import org.junit.Test;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class LC239_Sliding_Window_Maximum {

    @Test
    public void test() {
        maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<int[]> d = new LinkedList<>();
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; ++i) {
            while(d.size() > 0 && (d.peekLast()[0] <= nums[i] || d.peekLast()[1] <= i - k))
                d.pollLast();
            d.addLast(new int[]{nums[i], i});
            while(d.peekFirst()[1] <= i - k)
                d.pollFirst();
            if (i >= k - 1)
                ans[i - k + 1] = d.peekFirst()[0];
        }
        return ans;
    }

    /**
     * this method works but it is TLE
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindowTLE(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[nums.length - k + 1];

        PriorityQueue<Integer> pq = new PriorityQueue<>(k + 1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < nums.length; ++i) {
            pq.add(nums[i]);
            if (i >= k - 1) {
                res[i - k + 1] = pq.peek();
                pq.remove(nums[i - k + 1]);
            }
        }
        return res;
    }

}
