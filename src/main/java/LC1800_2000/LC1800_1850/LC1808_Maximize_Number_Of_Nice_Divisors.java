package LC1800_2000.LC1800_1850;

public class LC1808_Maximize_Number_Of_Nice_Divisors {

    public int maxNiceDivisors(int primeFactors) {

        return 1;
    }

    public long quickPow(int p, int q, int MOD) {
        long ans = 1L;
        long base = p;
        while (q != 0) {
            if ((q & 1) == 1) {
                ans = ans * base % MOD;
            }
            base = base * base % MOD;
            q >>>= 1;
        }
        return ans;
    }

}
