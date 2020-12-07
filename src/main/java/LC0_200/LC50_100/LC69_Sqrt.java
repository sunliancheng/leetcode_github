package LC0_200.LC50_100;

import org.junit.Test;

public class LC69_Sqrt {

    @Test
    public void test() {
        System.out.println(mySqrt(8));
    }

    public int mySqrt(int x) {

        if (x == 0) return x;
        int l = 1, r = x / 2 + 1, mid, sqrt;

        while (l <= r) {
            mid = l + (r - l) / 2;
            sqrt = x / mid;
            if (sqrt == mid)
                return mid;
            else if (mid > sqrt)
                r = mid - 1;
            else
                l = mid  + 1;
        }
        return r;

    }
}
