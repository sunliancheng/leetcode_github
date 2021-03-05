package LC200_400.LC300_350;

import org.junit.Test;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC301_Remove_Invalid_Parentheses {

    @Test
    public void test(){
        removeInvalidParentheses("())())");
    }

    private Set<String> validExpressions = new HashSet<>();

    private void recurse(String s, int index, int leftCount, int rightCount,
                         int leftRem, int rightRem, StringBuilder expression) {

        if (index == s.length()) {
            if (leftRem == 0 && rightRem == 0)
                this.validExpressions.add(expression.toString());
        } else {
            char character = s.charAt(index);
            int length = expression.length();
            // The discard case. Note that here we have our pruning condition.
            // We don't recurse if the remaining count for that parenthesis is == 0.
            if ((character == '(' && leftRem > 0) || (character == ')' && rightRem > 0)) {
                this.recurse(s, index + 1, leftCount, rightCount,
                        leftRem - (character == '(' ? 1 : 0), rightRem - (character == ')' ? 1 : 0), expression);
            }

            expression.append(character);

            // Simply recurse one step further if the current character is not a parenthesis.
            if (character != '(' && character != ')') {
                this.recurse(s, index + 1, leftCount, rightCount, leftRem, rightRem, expression);
            } else if (character == '(') {
                this.recurse(s, index + 1, leftCount + 1, rightCount, leftRem, rightRem, expression);
            } else if (rightCount < leftCount) {
                this.recurse(s, index + 1, leftCount, rightCount + 1, leftRem, rightRem, expression);
            }
            // Delete for backtracking.
            expression.deleteCharAt(length);
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                right = left == 0 ? right + 1 : right;
                left = left > 0 ? left - 1 : left;
            }
        }
        this.recurse(s, 0, 0, 0, left, right, new StringBuilder());
        return new ArrayList<>(this.validExpressions);
    }

}
