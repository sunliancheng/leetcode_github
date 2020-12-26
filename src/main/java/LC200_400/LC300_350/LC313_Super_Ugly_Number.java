package LC200_400.LC300_350;

import org.junit.Test;

import java.util.*;

public class LC313_Super_Ugly_Number {

    @Test
    public void te() {
        System.out.println(nthSuperUglyNumber(12, new int[]{2,7,13,19}));
        System.out.println(nthSuperUglyNumber(15, new int[]{3,5,7,11,19,23,29,41,43,47}));

    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) return 1;
        // init pq
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        while (n > 1 && !pq.isEmpty()) {
            int x = pq.poll();
            for (int p: primes) {
                long temp = (long)p * (long)x;
                if (temp < Integer.MAX_VALUE) {
                    pq.add((int)temp);
                }
            }
            while (pq.peek() == x) pq.poll();
            n--;
        }
        return pq.poll();

    }

}
