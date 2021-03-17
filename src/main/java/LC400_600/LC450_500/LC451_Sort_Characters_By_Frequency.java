package LC400_600.LC450_500;

import org.junit.Test;
import sun.awt.datatransfer.DataTransferer;

import java.util.*;
import java.util.Map.Entry;

public class LC451_Sort_Characters_By_Frequency {

    @Test
    public void test() {
        System.out.println(frequencySort("Aabb"));
    }

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            else map.put(s.charAt(i), 1);
        }

        List<Map.Entry<Character, Integer>> list =
                new ArrayList<Map.Entry<Character, Integer>>(map.entrySet());

        Collections.sort(list, (Entry<Character, Integer> o1, Entry<Character, Integer> o2) -> o2.getValue() - o1.getValue());

        StringBuilder sb = new StringBuilder();
        for (Entry<Character, Integer> entry : list) {
            for (int i = 0; i < entry.getValue(); ++i) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }

}
