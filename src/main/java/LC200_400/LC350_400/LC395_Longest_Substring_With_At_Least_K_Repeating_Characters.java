package LC200_400.LC350_400;

import org.junit.Test;

import java.util.*;

public class LC395_Longest_Substring_With_At_Least_K_Repeating_Characters {

    @Test
    public void test() {
        System.out.println(longestSubstring("aaabb", 3));
    }

    public int longestSubstring(String s, int k) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<>(), memo = new HashMap<>();
        for (int i = 0; i < s.length(); ++i)
            memo.put(s.charAt(i), 1 + memo.getOrDefault(s.charAt(i), 0));
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); ++i) {
            map.clear();
            if (memo.get(s.charAt(i)) < k) continue;
            map.put(s.charAt(i), 1 + map.getOrDefault(s.charAt(i), 0));
            for (int j = i; j < s.length(); ++j) {
                set.add(s.charAt(j));
                if (j != i) map.put(s.charAt(j), 1 + map.getOrDefault(s.charAt(j), 0));
                if (check(map, k)) {
                    result = result > j - i + 1 ? result : j - i + 1;
                }
            }
        }
        return result;
    }

    public boolean check(Map<Character, Integer> map, int k) {
        for (char c : map.keySet())
            if (map.get(c) < k) return false;
        return true;
    }

}
