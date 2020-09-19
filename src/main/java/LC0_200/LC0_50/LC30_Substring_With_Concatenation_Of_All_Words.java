package LC0_200.LC0_50;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *  2020-09-19 1:53 PM at Hangzhou
 */

public class LC30_Substring_With_Concatenation_Of_All_Words {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int wordLen = words[0].length();
        if (s.length() < (words.length * wordLen)) return result;
        HashMap<String, int[]> map = new HashMap<String, int[]>();

        for (int i = 0; i < words.length; i++) {
            int[] count = map.getOrDefault(words[i], new int[2]);
            count[0] += 1;
            count[1] += 1;
            map.put(words[i], count);
        }

        int len = 0, start = 0, i = 0;
        boolean countChanged = false;

        while ((i + wordLen) <= s.length()) {
            String word = s.substring(i, i + wordLen);
            boolean wordFound = false;
            if (map.containsKey(word) && map.get(word)[1] > 0) {
                --map.get(word)[1];
                ++len;
                i += wordLen;
                wordFound = true;
                countChanged = true;
            }

            if (len == words.length) {
                result.add(start);
                wordFound = false;
            }

            if (!wordFound) {
                if (countChanged)
                    resetCountMap(map);
                i = start + 1;
                start = i;
                len = 0;
                countChanged = false;
            }
        }
        return result;
    }

    private void resetCountMap(HashMap<String, int[]> map) {
        for (int[] count: map.values()) {
            count[1] = count[0];
        }
    }

    @Test
    public void test() {
        findSubstring("barfoothefoobarman", new String[]{"word","good", "best", "good"});
    }

}
