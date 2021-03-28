package LC1800_2000.LC1800_1850;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class LC1807_Evaluate_The_Bracket_Of_A_String {

    StringBuilder sb = new StringBuilder();
    Map<String, String> map = new HashMap<>();

    public String evaluate(String s, List<List<String>> knowledge) {
        Stack<Character> stack = new Stack<>();
        for (List<String> ls : knowledge)
            map.put(ls.get(0), ls.get(1));

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
