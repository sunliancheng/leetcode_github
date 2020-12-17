package LC200_400.LC200_250;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LC241_Different_Ways_To_Add_Parentheses {

    @Test
    public void test() {
        List<Integer> ls = diffWaysToCompute("2*3-4*5");
        for (int i : ls)
            System.out.print(i + " ");
    }


    // dp
    List<Integer> data = new ArrayList<>();
    List<Character> ops = new ArrayList<>();
    public List<Integer> diffWaysToCompute(String input) {
        int last = 0;
        // update data and ops
        for (int i = 0; i < input.length(); ++i) {
            char c = input.charAt(i);
            if (c == '-' || c == '+' || c == '*') {
                ops.add(c);
                data.add(Integer.valueOf(input.substring(last, i)));
                last = i + 1;
            }
        }
        data.add(Integer.valueOf(input.substring(last)));

        int n = data.size();
        List<Integer>[][] dp = new List[n][n];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                dp[i][j] = new ArrayList<>();

        for (int i = n; i >= 0; --i)
            for (int j = i; j < n; ++j)
                doThing(dp, i, j);

        return dp[0][n - 1];
    }

    private List<Integer> doThing(List<Integer>[][] dp, int i, int j) {
        if (dp[i][j].size() > 0)
            return dp[i][j];
        if (j == i) {
            dp[i][j].add(data.get(i));
        } else if (j - i == 1) {
            dp[i][j].add(cal(i, j));
        } else {
            for (int k = i; k < j; ++k) {
                List<Integer> left = doThing(dp, i, k);
                List<Integer> right = doThing(dp, k + 1, j);
                for (int l : left) {
                    for (int r : right) {
                        dp[i][j].add(cal(l, r, k));
                    }
                }
            }
        }
        return dp[i][j];
    }

    public int cal(int i, int j) {
        switch (ops.get(i)) {
            case '+' : return data.get(i) + data.get(j);
            case '-' : return data.get(i) - data.get(j);
            case '*' : return data.get(i) * data.get(j);
            default: return -1;
        }
    }

    public int cal(int i, int j, int k) {
        switch (ops.get(k)) {
            case '+' : return i + j;
            case '-' : return i - j;
            case '*' : return i * j;
            default: return -1;
        }
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
