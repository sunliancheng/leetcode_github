package LC1600_1800.LC1600_1650;

import org.junit.Test;

import java.util.HashMap;

public class LC1640_Check_Array_Formation_Through_Concatenation {

    @Test
    public void test() {
        System.out.println(canFormArray(new int[]{49, 18, 16},
                new int[][]{{16, 18, 49}}));
    }


    public boolean canFormArray(int[] arr, int[][] pieces) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; ++i)
            map.put(arr[i], i);

        for (int[] tem : pieces) {
            int idx = -3;
            for (int m : tem) {
                int index = map.getOrDefault(m, -1);
                if (index == -1 || index <= idx || idx >= 0 && index - idx != 1)
                    return false;
                idx = index;
            }
        }
        return true;
    }


}
