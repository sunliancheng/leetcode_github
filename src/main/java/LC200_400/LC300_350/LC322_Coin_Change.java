package LC200_400.LC300_350;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class LC322_Coin_Change {

    public int coinChange(int[] coins, int amount) {
        List<Integer> dp = new ArrayList();
        dp.add(0);
        for (int i = 1; i < amount + 1; ++i) {
            int small = Integer.MAX_VALUE- 1;
            for (int coin : coins)
                if (i - coin >= 0)
                    small = Math.min(small, dp.get(i - coin));
            dp.add(++small);
        }
        return dp.get(amount) == Integer.MAX_VALUE ? -1 : dp.get(amount);
    }
}
