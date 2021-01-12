package LC0_200.LC100_150;

import org.junit.Test;

/**
 *  2020-09-18 11:48 PM at Hangzhou
 *
 *  Surprisedly, I AC this problem on 2020-04-11, but now I actually forgot it
 */
public class LC121_Best_Time_To_Buy_And_Sell_Stock {

    public int maxProfit(int[] prices) {
        int profit = 0;
        int low = Integer.MAX_VALUE;
        for (int i : prices) {
            low = low < i ? low : i;
            int tem = i - low;
            profit = profit < tem ? tem : profit;
        }
        return profit;
    }


    @Test
    public void test() {

    }

}
