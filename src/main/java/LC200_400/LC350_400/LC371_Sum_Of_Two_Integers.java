package LC200_400.LC350_400;

import LeetCodeUtils.BitManipulation;
import org.junit.Test;

/**
 * 2020-09-24 10:12 PM at Hangzhou
 */
public class LC371_Sum_Of_Two_Integers {

    public int getSum(int a, int b) {
        int xor = a ^ b;
        int carry = a & b;
        if (carry == 0)
            return xor;
        else
            return getSum(xor, carry << 1);
    }

    @Test
    public void test() {
        System.out.println(getSum(4, 5));;
    }

}
