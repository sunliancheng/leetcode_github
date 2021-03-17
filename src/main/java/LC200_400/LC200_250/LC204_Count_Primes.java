package LC200_400.LC200_250;

public class LC204_Count_Primes {

    public int countPrimes(int n) {
        boolean[] marked = new boolean[n];
        int i = 0, c = 0;
        for (i = 2; i * i < n; ++i) {
            if (!marked[i]) {
                ++c;
                for (int j = i; j * i < n; ++j)
                    marked[j * i] = true;
            }
        }

        for (int j =i; j < n; ++j)
            if (!marked[j]) ++c;
        return c;
    }

}
