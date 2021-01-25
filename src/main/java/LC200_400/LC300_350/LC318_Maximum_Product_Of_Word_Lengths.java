package LC200_400.LC300_350;

import java.util.HashMap;
import java.util.Map;

public class LC318_Maximum_Product_Of_Word_Lengths {

    public int maxProduct(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (String word : words) {
            int mask = 0, size = word.length();
            for (int i = 0; i < word.length(); ++i) {
                mask |= 1 << (word.charAt(i) - 'a');
            }
            map.put(mask, Math.max(map.getOrDefault(mask, 0), size));
            for (int i : map.keySet()) {
                if ((mask & map.get(i)) == 0) {
                    ans = Math.max(ans, size * map.get(i));
                }
            }
        }
        return ans;
    }
}
