package LC0_200.LC0_50;

import org.junit.Test;

public class LC29_Divide_Two_Integers {

    @Test
    public void test() {
        System.out.println(divide(10, 3));
    }


    public int divide(int dividend, int divisor) {

        int sign = 1;
        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0)
            sign = -1;
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        long dividendM = Math.abs((long) dividend);
        long divisorM = Math.abs((long) divisor);

        int ans = 0;

        while (dividendM >= divisorM) {
            int bitNum = 0;
            while (dividendM >= (divisorM << bitNum))
                bitNum++;
            ans += 1 << (bitNum - 1);
            dividendM -= divisorM << (bitNum - 1);
        }
        return ans * sign;
    }



}
