package LC200_400.LC200_250;

import org.junit.Test;

import java.util.Stack;

/**
 * bad solution
 */
public class LC224_Basic_Calculater {

    @Test
    public void test() {
        System.out.println(calculate("(3-(5-(8)-(2+(9-(0-(8-(2))))-(4))-(4)))"));
    }

    public int calculate(String s) {
        int ans = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != ')') {
                if (s.charAt(i) != ' ')
                    stack.push(s.charAt(i));
            } else {
                int tem = 0;
                while (true) {
                    int inte = 0, flag = 0;
                    Character c = stack.pop();
                    while (c >= '0' && c <= '9') {
                        int t = 1;
                        for (int ii = 0; ii < flag; ++ii) {
                            t *= 10;
                        }
                        ++flag;
                        inte += t * (c - '0');
                        c = stack.pop();
                    }

                    if (c == '(') {
                        tem += inte;
                        break;
                    }
                    if (c == '-')
                        tem += -inte;
                    else
                        tem += inte;
                }
                if (tem >= 0)
                    stack.push('+');
                else
                    stack.push('-');

                boolean isPos = true;
                while (!stack.isEmpty() && (stack.peek() == '+' || stack.peek() == '-')) {
                    char ch = stack.pop();
                    if (ch == '-') {
                        isPos = isPos == true ? false : true;
                    }
                }
                if (isPos) {
                    stack.push('+');
                } else
                    stack.push('-');

                // push 48 into the stack
                Stack<Character> sta = new Stack<>();
                tem = tem < 0 ? -tem : tem;
                while (tem >= 10) {
                    int last = tem % 10;
                    sta.push((char) (last + '0'));
                    tem /= 10;
                }
                sta.push((char) (tem + '0'));
                for (int j = sta.size() - 1; j >= 0; --j)
                    stack.push(sta.get(j));
            }
        }

        for (int i = 0; i < stack.size(); ++i) {
            int tem = 0;
            boolean isPos = true;
            if (stack.get(i) == '-') {
                ++i;
                isPos = false;
            } else if (stack.get(i) == '+') {
                ++i;
            }
            while (i < stack.size() && stack.get(i) >= '0' && stack.get(i) <= '9') {
                tem = 10 * tem + stack.get(i) - '0';
                ++i;
            }
            --i;
            if (!isPos)
                tem = -tem;
            ans += tem;
        }
        return ans;
    }

}
