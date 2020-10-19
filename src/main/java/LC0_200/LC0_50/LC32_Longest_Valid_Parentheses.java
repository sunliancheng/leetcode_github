package LC0_200.LC0_50;

import java.util.Stack;

public class LC32_Longest_Valid_Parentheses {
    public int longestValidParentheses(String s) {

        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if(stack.empty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;

    }
}
