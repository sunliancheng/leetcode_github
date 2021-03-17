package LC400_600.LC500_550;

import org.junit.Test;

import java.util.*;

public class LC500_Keyboard_Row {

    @Test
    public void test() {
        System.out.println(findWords(new String[]{"Hello", }));
    }

    public String[] findWords(String[] words) {
        String row1 = "qwertyuiop", row2 = "asdfghjkl", row3 = "zxcvbnm";
        Map<Character, Integer> r1 = new HashMap<>(), r2 = new HashMap<>(), r3 = new HashMap<>();
        for (int i = 0; i < row1.length(); ++i)
            r1.put(row1.charAt(i), 1);
        for (int i = 0; i < row2.length(); ++i)
            r2.put(row2.charAt(i), 2);
        for (int i = 0; i < row3.length(); ++i)
            r3.put(row3.charAt(i), 3);

        List<String> ls = new ArrayList<>();

        for (String s : words) {
            String tem = s.toLowerCase();
            int idx = belongsTo(tem.charAt(0), r1, r2, r3);
            boolean flag = true;
            for (int i = 1; i < s.length(); ++i) {
                if (idx != belongsTo(tem.charAt(i), r1, r2, r3)) {
                    flag = false;
                    break;
                }
            }
            if (flag) ls.add(s);
        }
        return ls.toArray(new String[0]);
    }

    public int belongsTo(Character c, Map<Character, Integer> r1, Map<Character, Integer> r2, Map<Character, Integer> r3) {
        if (r1.containsKey(c)) return 1;
        if (r2.containsKey(c)) return 2;
        if (r3.containsKey(c)) return 3;
        return -1;
    }

}
