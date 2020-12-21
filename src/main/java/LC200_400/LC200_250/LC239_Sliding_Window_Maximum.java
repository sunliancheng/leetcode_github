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
        Deque<Integer> d = new LinkedList<>();
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; ++i) {
            if (!d.isEmpty() && i == d.peekFirst() + k)
                d.pollFirst();
            while (!d.isEmpty() && nums[d.peekLast()] < nums[i])
                d.pollLast();
            d.addLast(i);
            if (i >= k - 1)
                ans[i - k + 1] = nums[d.peekFirst()];
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
