package LC0_200.LC100_150;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC120_Triangle {

    @Test
    public void test() {
        List<List<Integer>> tri = new ArrayList<>();
        List<Integer> line1 = (new ArrayList<>()); line1.add(2);
        List<Integer> line2 = new ArrayList<>(); line2.add(3); line2.add(4);
        List<Integer> line3 = new ArrayList<>(); line3.add(6); line3.add(5); line3.add(7);
        List<Integer> line4 = new ArrayList<>(); line4.add(4); line4.add(1); line4.add(8); line4.add(3);
        tri.add(line1); tri.add(line2); tri.add(line3); tri.add(line4);

        System.out.println(minimumTotal(tri));

    }


    public int minimumTotal(List<List<Integer>> triangle) {

        int[][] dp = new int[triangle.size()][triangle.size()];
        for (int i = 0; i < dp[0].length; ++i)
            Arrays.fill(dp[i], 0);
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); ++i) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); ++j) {
                if (j == 0)
                    dp[i][j] = row.get(0) + dp[i - 1][j];
                else if (j == row.size() - 1)
                    dp[i][j] = row.get(row.size() - 1) + dp[i - 1][j - 1];
                else
                    dp[i][j] = row.get(j) + Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
            }
        }
        return Arrays.stream(dp[triangle.size() - 1]).min().getAsInt();
    }

    public int findMin(List<List<Integer>> triangle, int i, int j) {
        int tem1 = triangle.get(i).get(j), tem2 = j == 0 ? Integer.MAX_VALUE : triangle.get(i).get(j - 1), tem3 = j == i ? Integer.MAX_VALUE : triangle.get(i).get(j + 1);
        int ans = j;
        if (tem1 > tem2) {
            ans = j - 1;
            if (tem2 > tem3)
                ans = j + 1;
        } else {
            ans = j;
            if (tem1 > tem3)
                ans = j + 1;
        }
        return ans;
    }

}
