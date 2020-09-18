package LC0_200.LC100_150;

/**
 *  2020-09-18 11:48 PM at Hangzhou
 *
 *  Surprisedly, I AC this problem on 2020-04-11, but now I actually forgot it
 */
public class LC121_Best_Time_To_Buy_And_Sell_Stock {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int num : prices) {
            if (num < minPrice)
                minPrice = num;
            else if (maxProfit < num - minPrice)
                maxProfit = num - minPrice;
        }
        return maxProfit;
    }
}
