package LeetCodeUtils.Contest.C2021_03_28;

import org.junit.Test;

import java.util.*;
import java.util.Stack;

public class Third {

    @Test
    public void test() {
        List<String> l1 = new ArrayList<>();
        l1.add("a"); l1.add("b");
        List<String> l2 = new ArrayList<>();
        l2.add("b"); l2.add("a");
        List<List<String>> list = new ArrayList<>();
        list.add(l1); list.add(l2);
        System.out.println(evaluate("(a)(b)", list));
    }


    StringBuilder sb = new StringBuilder();
    Map<String, String> map = new HashMap<>();

    public String evaluate(String s, List<List<String>> knowledge) {
        Stack<Character> stack = new Stack<>();
        for (List<String> ls : knowledge) {
            map.put(ls.get(0), ls.get(1));
        }
        add(s);
        return sb.toString();
    }

    public void add(String s) {
        if (s.length() == 0) return;
        int first = s.indexOf("(");
        if (first != -1) {
            sb.append(s.substring(0, first));
            s = s.substring(first);
        }
        int end = s.indexOf(")"); first = 0;
        if (end == -1) {
            sb.append(s);
            return;
        } else {
            String key = s.substring(first + 1, end);
            sb.append(map.getOrDefault(key, "?"));
            add(s.substring(end + 1));
        }
    }


}
