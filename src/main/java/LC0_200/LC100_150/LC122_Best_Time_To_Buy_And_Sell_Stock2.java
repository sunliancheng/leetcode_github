package LC0_200.LC100_150;

import LeetCodeUtils.MyMatrix;
import org.junit.Test;

public class LC122_Best_Time_To_Buy_And_Sell_Stock2 {

    @Test
    public void test() {
        System.out.println(maxProfit(MyMatrix.OneDIntMatrixAdapter("[7,1,5,3,6,4]")));
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        int lastLow = -1;
        for (int i = 0; i < prices.length; ++i) {
            if (i == 0) {
                lastLow = prices[i];
                continue;
            }
            if (i < prices.length - 1 && prices[i] > prices[i + 1]) {
                profit += Math.max(0, prices[i] - lastLow);
                lastLow = prices[i];
            }
            if (prices[i] < prices[i - 1])
                lastLow = prices[i];
            if (i == prices.length - 1)
                profit += Math.max(0, prices[i] - lastLow);
        }
        return profit;
    }

    /**
     * Say you have an array prices for which the ith element
     * is the price of a given stock on day i.
     *
     * Design an algorithm to find the maximum profit.
     * You may complete as many transactions as you like
     * (i.e., buy one and sell one share of the stock multiple times).
     *
     * Note: You may not engage in multiple transactions at the same time
     * (i.e., you must sell the stock before you buy again).
     */

}
