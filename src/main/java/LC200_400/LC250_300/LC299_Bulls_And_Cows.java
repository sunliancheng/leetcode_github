package LC200_400.LC250_300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC299_Bulls_And_Cows {
    public String getHint(String secret, String guess) {
        StringBuilder sb1 = new StringBuilder(secret);
        StringBuilder sb2 = new StringBuilder(guess);
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int a = 0, b = 0; List<Integer> ls = new ArrayList<Integer>();
        for (int i = 0; i < sb1.length(); ++i) {
            if (sb1.charAt(i) == sb2.charAt(i)) {
                ++a;
                ls.add(i);
            } else {
                if (!map.containsKey(sb1.charAt(i))) {
                    map.put(sb1.charAt(i), 1);
                } else {
                    int n = map.get(sb1.charAt(i));
                    map.put(sb1.charAt(i), ++n);
                }
            }
        }
        for (int i = ls.size() - 1; i >= 0; --i) {
            sb1.deleteCharAt(ls.get(i));
            sb2.deleteCharAt(ls.get(i));
        }
        for (int i = 0; i < sb2.length(); ++i) {
            Integer n = map.get(sb2.charAt(i));
            if (n != null && n != 0) {
                map.put(sb2.charAt(i), --n);
                b++;
            }
        }
        return a + "A" + b + "B";
    }
}
