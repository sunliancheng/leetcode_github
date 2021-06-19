package LC200_400.LC200_250;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LC241_Different_Ways_To_Add_Parentheses {

    @Test
    public void test() {
        diffWaysToCompute("2").forEach(System.out::println);
    }


    // dp
    public List<Integer> diffWaysToCompute(String expression) {

        List<Integer> data = new ArrayList<>();
        List<Character> ops = new ArrayList<>();

        // pre-handle the expression
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < expression.length(); ++i) {
            char c = expression.charAt(i);
            if (c == '-' || c == '+' || c == '*') {
                data.add(Integer.valueOf(sb.toString()));
                ops.add(c);
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
            if (i == expression.length() - 1) {
                data.add(Integer.valueOf(sb.toString()));
            }
        }

        int n = data.size();
        // define the dp matrix
        List<Integer>[][] dp = new ArrayList[n][n];

        for (int i = 0; i < n; ++i) {
            for (int j = i; j >= 0; --j) {
                dp[j][i] = new ArrayList<>();
                if (i == j) {
                    dp[j][i].add(data.get(i));
                } else {
                    for (int k = j; k < i; ++k) {
                        for (int left : dp[j][k]) {
                            for (int right : dp[k + 1][i]) {
                                int val = 0;
                                switch(ops.get(k)) {
                                    case '-' : val = left - right; break;
                                    case '+' : val = left + right; break;
                                    case '*' : val = left * right; break;
                                }
                                dp[j][i].add(val);
                            }
                        }
                    }
                }
            }
        }
        return dp[0][n - 1];

    }


    // divide and conquer
    public List<Integer> diffWaysToCompute2(String input) {
        List<Integer> ways = new ArrayList<>();
        for (int i = 0; i < input.length(); ++i) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int l : left) {
                    for (int r : right)
                        if (c == '+') {
                            ways.add(r + l);
                            break;
                        }
                        else if (c == '-') {
                            ways.add(l - r);
                            break;
                        }
                        else {
                            ways.add(l * r);
                            break;
                        }
                }
            }
        }
        if (ways.isEmpty())
            ways.add(Integer.valueOf(input));
        return ways;
    }

}
