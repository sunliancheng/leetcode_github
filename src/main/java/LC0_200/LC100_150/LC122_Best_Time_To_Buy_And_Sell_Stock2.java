package LC0_200.LC100_150;

import LeetCodeUtils.MyMatrix;
import org.junit.Test;

public class LC122_Best_Time_To_Buy_And_Sell_Stock2 {

    @Test
    public void test() {
        System.out.println(maxProfit(MyMatrix.OneDIntMatrixAdapter("[1,2,3,4,5]")));
    }



    public int maxProfit(int[] prices) {
        int profit = 0;
        int lastHigh = prices[0], lastLow = prices[0];
        for (int i = 1; i < prices.length; ++i)
            if (lastHigh > prices[i]) {
                profit += lastHigh - lastLow;
                lastHigh = lastLow = prices[i];
            } else
                lastHigh = prices[i];
        return profit + lastHigh - lastLow;
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
