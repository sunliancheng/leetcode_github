package LC400_600.LC500_550;

import org.junit.Test;

public class LC526_Beautiful_Arrangement {

    @Test
    public void test() {
    }

    int count = 0;
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];
        calculate(n, 1, visited);
        return count;
    }

    public void calculate(int n, int pos, boolean[] visited) {
        if (pos > n) count++;
        for (int i = 1; i <= n; ++i) {
            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                visited[i] = true;
                calculate(n, pos + 1, visited);
                visited[i] = false;
            }
        }
    }

}
