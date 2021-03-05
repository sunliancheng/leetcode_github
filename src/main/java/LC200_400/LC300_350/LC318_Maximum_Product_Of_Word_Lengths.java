package LC200_400.LC300_350;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LC318_Maximum_Product_Of_Word_Lengths {

    @Test
    public void test() {
        System.out.println(maxProduct(new String[]{"a","ab","abc","d","cd","bcd","abcd"}));
    }

    public int maxProduct(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (String word : words) {
            int mask = 0, len = word.length();
            for (int i = 0; i < word.length(); ++i)
                mask |= 1 << word.charAt(i) - 'a';

            int l = map.getOrDefault(mask, 0);
            l = l > len ? l : len;
            map.put(mask, l);

            for (int i : map.keySet()) {
                if ((i & mask) == 0) {
                    int tem = map.get(i) * l;
                    ans = ans > tem ? ans : tem;
                }
            }
        }
        return ans;
    }
}
