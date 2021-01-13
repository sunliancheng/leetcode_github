package LC0_200.LC150_200;

import org.junit.Test;

public class LC188_Best_Time_To_Buy_And_Sell_Stock4 {

    @Test
    public void test() {
        maxProfit(2, new int[]{3,2,6,5,0,3});
    }

    public int maxProfit(int k, int[] prices) {
        if(k >= prices.length / 2) return find(k, prices);
        if(prices.length == 0 || prices.length == 1) return 0;
        int[][] dp = new int[k + 1][prices.length + 1];
        int temp;
        for(int i = 1; i < k + 1; ++i) {
            temp = prices[0];  //refers to the buy point
            for(int j = 1; j < prices.length; ++j) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] - temp);  //sell
                temp = Math.min(temp, prices[j] - dp[i-1][j-1]); //buy, used for next sell
            }
        }
        return dp[k][prices.length - 1];
    }

    public int find(int k, int[] prices){
        int count = 0;
        for(int i = 1; i < prices.length; ++i)
            if(prices[i] - prices[i-1] > 0) count += prices[i] - prices[i-1];
        return count;
    }
}
