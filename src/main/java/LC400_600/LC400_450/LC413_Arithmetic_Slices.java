package LC400_600.LC400_450;

public class LC413_Arithmetic_Slices {



    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3)
            return 0;
        int[] dp = new int[A.length];
        for (int i = 2; i < A.length; ++i) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2])
                dp[i] = dp[i - 1] + 1;
        }
        int ans = 0;
        for (int i : dp)
            ans += i;
        return ans;
    }

}
