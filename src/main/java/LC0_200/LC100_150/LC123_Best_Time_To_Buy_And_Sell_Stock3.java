package LC0_200.LC100_150;

public class LC123_Best_Time_To_Buy_And_Sell_Stock3 {

    public int maxProfit(int[] prices) {
        int onebuy = Integer.MAX_VALUE;
        int twobuy = Integer.MAX_VALUE;
        int profit = 0;
        int profit_all = 0;
        for(int price : prices){
            onebuy = Math.min(onebuy, price);
            profit = Math.max(profit, price - onebuy);
            twobuy = Math.min(twobuy, price - profit);
            profit_all = Math.max(profit_all, price - twobuy);
        }

        return Math.max(profit, profit_all);
    }

}
