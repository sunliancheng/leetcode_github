package LC200_400.LC350_400;

import org.junit.Test;

import java.util.PriorityQueue;

public class LC378_Kth_Smallest_Element_In_A_Sorted_Matrix {

    @Test
    public void test() {
        System.out.println(kthSmallest(new int[][]{{1,2}, {1,3}}, 1));
    }


    public int kthSmallest(int[][] matrix, int k) {
        if (k == 1) return matrix[0][0];
        PriorityQueue<Integer> pq = new PriorityQueue();
        for (int i = 0; i < matrix.length; ++i)
            for (int j = 0; j < matrix[0].length; ++j)
                pq.offer(matrix[i][j]);

        for (int i = 1; i < k; ++i)
            pq.remove();

        return pq.remove();
    }

}
