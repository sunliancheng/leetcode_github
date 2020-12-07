package LC200_400.LC350_400;

import java.util.Stack;

public class LC394_Decode_String {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<Character>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); ++i)
            if (s.charAt(i) == ']') {
                StringBuilder num = new StringBuilder();
                StringBuilder sb = new StringBuilder();
                while (stack.peek() != '[')
                    sb.append(stack.pop());
                stack.pop();
                if (stack.peek() >= '0' && stack.peek() <= '9') {
                    while (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9')
                        num.append(stack.pop());
                } else
                    num.append(1);
                int n = Integer.valueOf(num.reverse().toString());
                for (int j = 0; j < n; ++j)
                    for (int k = sb.length() - 1; k >= 0; --k)
                        stack.push(sb.charAt(k));
            } else
                stack.push(s.charAt(i));
        for (Character c : stack)
            result.append(c);

        return result.toString();
    }
}
