package LC400_600.LC400_450;

import org.junit.Test;

import java.util.*;

public class LC438_Find_All_Anagrams_In_A_String {

    @Test
    public void test() {
        System.out.println(findAnagrams("aaaaaaaaaa", "aaaaaaaaaaaaa"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> reslt = new ArrayList<>();
        if (s.length() == 0 || p.length() == 0 || p.length() > s.length()) return reslt;
        int l = 0, r = l + p.length() - 1;
        int[] a = new int[26], b = new int[26];
        for (int i = 0; i < p.length(); ++i) {
            a[s.charAt(i) - 'a']++;
            b[p.charAt(i) - 'a']++;
        }
        while (l < s.length() && r < s.length()) {
            if (Arrays.equals(a, b)) reslt.add(l);
            a[s.charAt(l) - 'a']--;
            l++; r = l + p.length() - 1;
            if (r < s.length()) a[s.charAt(r) - 'a']++;
        }
        return reslt;
    }

}
