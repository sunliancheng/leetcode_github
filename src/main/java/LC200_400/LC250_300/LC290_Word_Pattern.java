package LC200_400.LC250_300;

import java.util.HashMap;

public class LC290_Word_Pattern {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<Character, String>();
        String[] list = str.split(" ");
        if (pattern.length() != list.length)
            return false;
        for (int i = 0; i < pattern.length(); ++i) {
            if (!map.containsKey(pattern.charAt(i)) && !map.containsValue(list[i])) {
                map.put(pattern.charAt(i), list[i]);
            } else
                if (map.get(pattern.charAt(i)) != null && map.get(pattern.charAt(i)).equals(list[i])) {

                } else
                    return false;
        }
        return true;
    }
}
