package LC600_800.LC750_800;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 *  1 2 3 5
 */
public class LC786_K_th_Smallest_Prime_Fraction {

    @Test
    public void test() {
        //int[] re = kthSmallestPrimeFraction(new int[]{1, 7}, 1);
        int[] re = kthSmallestPrimeFraction(new int[]{1,2,3,5}, 3);
        System.out.println(re[0] + " " + re[1]);
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        if (arr.length == 1) return new int[]{arr[0], arr[0]};
        if (k == 1) return new int[]{arr[0], arr[arr.length - 1]};
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(a[0], b[0]));
        for (int i = 0; i < arr.length; ++i)
            pq.add(new double[]{(double) arr[i] / arr[arr.length - 1], (double) i, (double) arr.length - 1});
        int[] result = new int[2];
        while (pq.size() > 0 && --k >= 0) {
            double[] poll = pq.poll();
            int first = (int) poll[1], second = (int) poll[2];
            if (k == 0) {
                result[0] = arr[first];
                result[1] = arr[second];
                break;
            }
            second--;
            if (second >= first)
                pq.add(new double[]{(double) arr[first] / arr[second], (double) first, (double) second});
        }
        return result;
    }

}
