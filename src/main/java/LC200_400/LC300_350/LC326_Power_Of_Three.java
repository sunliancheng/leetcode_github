package LC200_400.LC300_350;

public class LC326_Power_Of_Three {
    public boolean isPowerOfThree(int n) {

        if (n < 1)
            return false;

        while (n % 3 == 0)
            n /= 3;

        return n == 1;
    }
}
