package LC200_400.LC300_350;

public class LC326_Power_Of_Three {

    /**
     * 在 int 范围内 3 的最大的次方是 19次方 = 1162261467；
     * 所以如果一个数是3的次方，必定能被 3的19次方整除
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
