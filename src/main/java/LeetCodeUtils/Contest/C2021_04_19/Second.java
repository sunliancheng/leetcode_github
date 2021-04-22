package LeetCodeUtils.Contest.C2021_04_19;

import java.util.Arrays;

public class Second {

    public int maxIceCream(int[] costs, int coins) {
        int count = 0;
        Arrays.sort(costs);
        for (int cost : costs) {
            if (coins >= cost) count++;
            else break;
            coins -= cost;
        }
        return count;
    }

}
