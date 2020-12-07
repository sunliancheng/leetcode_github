package LC200_400.LC200_250;

public class LC231_Power_Of_Two {
    boolean isPowerOfTwo(int n) {
        if (n == 0)
            return false;
        if (n == Integer.MIN_VALUE)
            return false;
        n = n & (n - 1);

        if (n == 0)
            return true;
        return false;
    }
}
