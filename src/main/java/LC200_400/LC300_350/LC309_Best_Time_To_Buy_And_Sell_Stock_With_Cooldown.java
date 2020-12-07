package LC200_400.LC300_350;

public class LC309_Best_Time_To_Buy_And_Sell_Stock_With_Cooldown {
    public int maxProfit(int[] prices) {

        if(prices.length == 1 || prices.length == 0) return 0;
        int[] dp = new int[prices.length];
        int temp = prices[0]; int flag = 0;
        for(int j = 1; j < prices.length; ++j){
            dp[j] = Math.max(dp[j-1], prices[j] - temp);
            if(j >= 2)
                temp = Math.min(temp, prices[j] - dp[j - 2]);
            else temp = Math.min(temp, prices[j] - dp[j - 1]);

        }
        return dp[prices.length - 1];
    }
}
