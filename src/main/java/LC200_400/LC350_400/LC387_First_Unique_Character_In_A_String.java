package LC200_400.LC350_400;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class LC387_First_Unique_Character_In_A_String {

    @Test
    public void test() {
        System.out.println(firstUniqChar("leetcode"));
    }


    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            arr[s.charAt(i) - 'a']++;
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == 1) {
                set.add((char) (i + 'a'));
            }
        }
        for (int i = 0; i < s.length(); ++i) {
            if (set.contains(s.charAt(i))) return i;
        }
        return -1;
    }
}
