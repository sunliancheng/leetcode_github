package LC200_400.LC300_350;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LC336_Palindrome_Pairs {

    @Test
    public void test() {
        System.out.println(check(new String[]{"bat", "tab"}, 0, 1));
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> re = new ArrayList<>();
        for (int i = 0; i < words.length; ++i) {
            for (int j = i + 1; j < words.length; ++j) {
                if (check(words, i, j)) {
                    List<Integer> t = new ArrayList<>();
                    t.add(i); t.add(j);
                    re.add(t);
                }
                if (check(words, j, i)) {
                    List<Integer> t = new ArrayList<>();
                    t.add(j); t.add(i);
                    re.add(t);
                }
            }
        }
        return re;
    }

    public boolean check(String[] words, int i, int j) {
        String tem = words[i] + words[j];
        int l = 0, r = tem.length() - 1;
        while (l <= r) {
            if (tem.charAt(l) != tem.charAt(r)) return false;
            ++l; --r;
        }
        return true;
    }

}
