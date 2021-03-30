package LC600_800.LC600_650;

import org.junit.Test;

import java.util.*;

public class LC621_Task_Scheduler {

    @Test
    public void test() {
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }

    public int leastInterval(char[] tasks, int n) {

        if (n == 0) return tasks.length;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) map.put(c, map.getOrDefault(c, 0) + 1);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int val : map.values()) pq.offer(val);

        int rtn = 0;
        while (!pq.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i <= n; ++i) {
                if (pq.isEmpty()) break;
                int poll = pq.poll();
                list.add(poll);
            }

            for (int t : list) {
                --t;
                if (t > 0) pq.offer(t);
            }
            if (pq.isEmpty()) rtn = rtn + list.size();
            else rtn = rtn + n + 1;
        }
        return rtn;
    }

    /**
     * Given a characters array tasks,
     * representing the tasks a CPU needs to do,
     * where each letter represents a different task.
     * Tasks could be done in any order.
     * Each task is done in one unit of time.
     * For each unit of time, the CPU could complete either one task or just be idle.
     *
     * However, there is a non-negative integer n that
     * represents the cooldown period between two same tasks (the same letter in the array),
     * that is that there must be at least n units of time between any two same tasks.
     *
     * Return the least number of units of times that the CPU will take to finish all the given tasks.
     */

}
