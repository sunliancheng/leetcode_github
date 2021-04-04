package LC1800_2000.LC1800_1850;

public class LC1819_Number_Of_Different_Subsequences_GCDS {


    public int countDifferentSubsequenceGCDs(int[] nums) {
        boolean[] visited = new boolean[200005];
        int max = Integer.MIN_VALUE;
        for (int n : nums) {
            visited[n] = true;
            max = Math.max(max, n);
        }
        int count = 0;
        for (int i = 1; i <= max; ++i) {
            int commonGCD = -1;
            for (int j = i; j <= max; j += i) {
                if (visited[j]) {
                    if (commonGCD == -1) commonGCD = j;
                    else commonGCD = gcd(commonGCD, j);
                }
            }
            if (i == commonGCD) count++;
        }
        return count;
    }

    //
    private int gcd(int x, int y) {
        if (x == 0) return y;
        return gcd(y % x, x);
    }

}
