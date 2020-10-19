package LC0_200.LC0_50;

import java.util.LinkedList;
import java.util.Queue;

public class LC7_Reverse_Integer {

    int reverse(int x) {
        Queue<Integer> queue = new LinkedList<>();

        while(x >= 10 || x <= -10) {
            queue.offer(x % 10);
            x = x / 10;
        }
        queue.offer(x);

        double sum = 0;
        while(!queue.isEmpty()) {
            sum = sum * 10 + queue.poll();
        }
        if(sum > Math.pow(2, 31) - 1 || sum < -Math.pow(2, 31)) {
            return 0;
        }
        return (int) sum;
    }

}
