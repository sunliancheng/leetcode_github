package LC0_200.LC50_100;

public class LC96_Unique_Binary_Search_Trees {
    public int numTrees(int n) {
        if(n == 1) return 1;
        if(n == 0) return 0;
        if(n == 2) return 2;

        int[] g = new int[n + 1];
        g[1] = 1; g[2] = 2; g[0] = 1;

        for(int i = 3; i <= n; ++i)
            calG(i, g);

        return g[n];
    }

    public int calG(int n, int[] g){
        if(g[n] != 0) return g[n];

        int result = 0;
        for(int i = 1; i <= n; ++i){
            //result += g[i - 1] * g[n - i];
            result += g[i - 1] * g[n - i];
        }
        g[n] = result;
        return result;
    }
}
