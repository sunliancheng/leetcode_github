package LC0_200.LC0_50;

import java.util.HashSet;
import java.util.Stack;

public class LC20_Valid_Parentheses {
    public boolean isValid(String s) {
        HashSet<Character> set1 = new HashSet<Character>();
        set1.add('['); set1.add('{'); set1.add('(');
        HashSet<Character> set2 = new HashSet<Character>();
        set2.add(']'); set2.add('}'); set2.add(')');
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); ++i) {
            if (set1.contains(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (set2.contains(s.charAt(i))) {
                if (stack.isEmpty())
                    return false;
                Character c = stack.pop();
                if (s.charAt(i) == ']') {
                    if (c != '[')
                        return false;
                } else if (s.charAt(i) == '}') {
                    if (c != '{')
                        return false;
                } else if (s.charAt(i) == ')') {
                    if (c != '(')
                        return false;
                }
            } else {
                return false;
            }
        }
        if (stack.isEmpty())
            return true;
        return false;
    }


}
