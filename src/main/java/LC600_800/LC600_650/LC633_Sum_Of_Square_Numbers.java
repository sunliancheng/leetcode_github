package LC600_800.LC600_650;

public class LC633_Sum_Of_Square_Numbers {



    public boolean judgeSquareSum(int c) {
        int r = (int) Math.sqrt(c) + 1;
        if ((r - 1) * (r - 1) == c)
            return true;
        int left = 0;
        while (left <= r) {
            int sum = left * left + r * r;
            if (sum == c)
                return true;
            else if (sum < c)
                ++left;
            else
                --r;
        }
        return false;
    }

    /**
     * Given a non-negative integer c,
     * decide whether there're two integers a and b such that a2 + b2 = c.
     */

}
