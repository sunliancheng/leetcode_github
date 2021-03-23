package LC200_400.LC350_400;

import java.util.*;

public class LC380_Insert_Delete_GetRandom_O1 {

}

class RandomizedSet {

    Set<Integer> set = null;
    Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        set = new HashSet<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        return set.add(val);
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!set.contains(val)) return false;
        set.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int random_val = random.nextInt(set.size());
        int current = 0;
        for(int i: set){
            if(current == random_val) return i;
            current++;
        }
        return 0;
    }
}