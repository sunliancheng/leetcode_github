package LC400_600.LC550_600;

import java.util.HashSet;
import java.util.Set;

public class LC575_Distribute_Candies {

    public int distributeCandies(int[] candyType) {
        int nu = candyType.length / 2;
        Set<Integer> set = new HashSet<>();
        for (int i : candyType) {
            set.add(i);
        }
        return nu <= set.size() ? nu : set.size();
    }

}
