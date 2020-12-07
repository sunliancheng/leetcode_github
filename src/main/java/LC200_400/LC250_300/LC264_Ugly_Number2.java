package LC200_400.LC250_300;

public class LC264_Ugly_Number2 {
    public int nthUglyNumber(int n) {
        if(n <= 1)
            return n;
        int t1 = 0;
        int t2 = 0;
        int t3 = 0;
        int[] k = new int[n];
        k[0] = 1;

        for(int i = 1; i < n; ++i) {
            k[i] = Math.min(Math.min(k[t1] * 2, k[t2] * 3), k[t3] * 5);

            if(k[i] == k[t1] * 2)
                t1++;
            if(k[i] == k[t2] * 3)
                t2++;
            if(k[i] == k[t3] * 5)
                t3++;
        }

        return k[n - 1];
    }
}
