package LC200_400.LC300_350;

public class LC338_Counting_Bits {

    public int[] countBits(int num) {

        int[] dp = new int[num + 1];

        for (int i = 1; i <= num; ++i)
            dp[i] = dp[i >> 1] + (i & 1);

        return dp;

        /**
         * the number of 1101 is the sum of 110 and 1
         * in that case, the equation will be :
         * dp[1101] = dp[110] + (1 & i)
         */

        /**
         *  0 <= i <= num
         *
         *  0000
         *  0001
         *
         *  0010
         *  0011
         *
         *  0100
         *  0101
         *
         *  0110
         *  0111
         */

    }

}
