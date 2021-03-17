package LC200_400.LC300_350;

import org.junit.Test;
import sun.awt.datatransfer.DataTransferer;

import java.util.*;

public class LC347_Top_K_Frequent_Elements {

    @Test
    public void test() {
        System.out.println(topKFrequent(new int[]{1,1,1,2,2,3}, 2));
    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums)
            map.put(i, 1 + map.getOrDefault(i, 0));

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) -> o2.getValue() - o1.getValue());

        for (int i = 0; i < k; ++i) {
            Map.Entry<Integer, Integer> remove = list.remove(0);
            result[i] = remove.getKey();
        }
        return result;
    }

}
