package LC600_800.LC750_800;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class LC791_Daily_Temperatures {

    /**
     *  这题的本质和左右括号匹配差不多，这不过这里是一个右括号匹配多个左括号模式
     */

    @Test
    public void test() {
        dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
    }

    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        int n = T.length;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty()) {
                int pre = stack.peek();
                if (T[i] <= T[pre])
                    break;
                stack.pop();
                ans[pre] = i - pre;
            }
            stack.push(i);
        }
        return ans;
    }

}
