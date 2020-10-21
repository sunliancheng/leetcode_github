package LC200_400.LC350_400;

import org.junit.Test;

import java.util.*;


public class LC365_Water_And_Jug_Problem {

    @Test
    public void test() {

        System.out.println(canMeasureWater(104579, 104593, 12444));
        System.out.println(canMeasureWater(2, 1, 5));
    }


    public boolean canMeasureWater(int x, int y, int z) {
        Deque<int[]> stack = new LinkedList<int[]>();
        stack.push(new int[]{0, 0});
        Set<Long> seen = new HashSet<Long>();
        while(!stack.isEmpty()) {
            if (seen.contains(hash(stack.peek()))) {
                stack.pop();
                continue;
            }
            seen.add(hash(stack.peek()));

            int[] state = stack.pop();
            int remain_x = state[0], remain_y = state[1];
            if (remain_x == z || remain_y == z || remain_x + remain_y == z)
                return true;
            if (remain_x != x)
                stack.push(new int[]{x, remain_y});
            if (remain_y != y)
                stack.push(new int[]{remain_x, y});
            if (x != 0)
                stack.push(new int[]{0, remain_y});
            if (y != 0)
                stack.push(new int[]{remain_x, 0});
            stack.push(new int[]{remain_x - Math.min(remain_x, y - remain_y), remain_y + Math.min(remain_x, y - remain_y)});
            stack.push(new int[]{remain_x + Math.min(remain_y, x - remain_x), remain_y - Math.min(remain_y, x - remain_x)});
        }
        return false;
    }

    public long hash(int[] state) {
        return (long) state[0] * 1000001 + state[1];
    }




    /**
     * 1. poll out x
     * 2. poll out y
     * 3. put in x
     * 4. put in y
     * 5. x - y
     * 6. y - x
     */

    /**
     * You are given two jugs with capacities x and y litres.
     * There is an infinite amount of water supply available.
     * You need to determine whether it is possible to measure exactly z litres using these two jugs.
     *
     * If z liters of water is measurable,
     * you must have z liters of water contained within one or both buckets by the end.
     *
     * Operations allowed:
     *
     * Fill any of the jugs completely with water.
     * Empty any of the jugs.
     * Pour water from one jug into another till the other jug is completely full or the first jug itself is empty.
     * Example 1: (From the famous "Die Hard" example)
     *
     * Input: x = 3, y = 5, z = 4
     * Output: True
     * Example 2:
     *
     * Input: x = 2, y = 6, z = 5
     * Output: False
     */

}
