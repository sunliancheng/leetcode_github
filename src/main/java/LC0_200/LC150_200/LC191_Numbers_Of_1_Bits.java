package LC0_200.LC150_200;

import org.junit.Test;

public class LC191_Numbers_Of_1_Bits {

    @Test
    public void test() {
        System.out.println(hammingWeight(3));
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0, mask = 1;
        for (int i = 0; i < 32; ++i) {
            if ((mask & n) != 0)
                ++ans;
            mask <<= 1;
        }
        return ans;
    }

}
