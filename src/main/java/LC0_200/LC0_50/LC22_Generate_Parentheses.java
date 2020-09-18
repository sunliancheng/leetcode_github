package LC0_200.LC0_50;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *  2020-09-19 12:49 AM at Hangzhou
 */
public class LC22_Generate_Parentheses {

    private List<String> result = new ArrayList<String>();

    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        fact(n, n, sb);
        return result;
    }

    public void fact(int left, int right, StringBuilder sb) {
        if (left == 0 && right == 0) {
            result.add(sb.toString());
            return;
        } else if (left == 0) {
            for (int i = 0; i < right; ++i)
                sb.append(')');
            result.add(sb.toString());
            sb.delete(sb.length() - right - 1 ,sb.length() - 1);
            return;
        }

        if (left > 0) {
            sb.append('(');
            fact(--left, right, sb);
            sb.deleteCharAt(sb.length() - 1);
            ++left;
        }

        if (right > 0 && (right > left)) {
            sb.append(')');
            fact(left, --right, sb);
            sb.deleteCharAt(sb.length() - 1);
            ++right;
        }
    }

    @Test
    public void test() {
        generateParenthesis(3);
    }

}
