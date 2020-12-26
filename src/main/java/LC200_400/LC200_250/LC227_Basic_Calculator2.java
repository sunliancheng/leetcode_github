package LC200_400.LC200_250;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class LC227_Basic_Calculator2 {

    @Test
    public void test() {
        System.out.println(calculate("5/2*3"));
    }

    public int calculate(String s) {
        int i = 0;
        return parseExps(s, i);
    }

    int parseExps(String s, int i) {
        char op = '+';
        int left = 0, right = 0;
        while (i < s.length()) {
            if (s.charAt(i) != ' ') {
                int n = parseNum(s, i);
                switch (op) {
                    case '+' : left += right; right = n; break;
                    case '-' : left += right; right = -n; break;
                    case '*' : right *= n; break;
                    case '/' : right /= n; break;
                }
                if (i < s.length())
                    op = s.charAt(i);
            }
            ++i;
        }
        return left + right;
    }

    int parseNum(String s, int i) {
        int n = 0;
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9')
            n = 10 * n + s.charAt(i++) - '0';
        return n;
    }


}
