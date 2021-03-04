package LC200_400.LC300_350;

import org.junit.Test;

public class LC343_Integer_Break {

    @Test
    public void test() {
        System.out.println(integerBreak(6));
    }

    public int integerBreak(int n) {
        if (n == 2) return 1;
        return f(n, new int[n + 1]);
    }

    public int f(int n, int[] memory) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (memory[n] != 0) return memory[n];
        int result = 0;
        for (int i = 2; i < n; ++i) {
            int re = f(n - i, memory);
            re = re > n - i ? re : n - i;
            re = i * re;
            result = result > re ? result : re;
        }
        memory[n] = result;
        return result;
    }

}
