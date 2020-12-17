package LC600_800.LC750_800;

import org.junit.Test;

public class LC769_Max_Chunks_To_Make_Sorted {

    @Test
    public void test() {
        System.out.println(maxChunksToSorted(new int[]{4,1,3,2}));
    }

    public int maxChunksToSorted(int[] arr) {
        int chunks = 0, cur_max = 0;
        for (int i = 0; i < arr.length; ++i) {
            cur_max = Math.max(cur_max, arr[i]);
            if (cur_max == i)
                ++chunks;
        }
        return chunks;
    }

}
