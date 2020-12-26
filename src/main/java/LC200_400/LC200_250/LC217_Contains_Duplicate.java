package LC200_400.LC200_250;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class LC217_Contains_Duplicate {

    @Test
    public void test() {
        System.out.println(containsDuplicate(new int[]{0}));
    }


    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set= new HashSet<>();
        for (int i : nums) {
            if (!set.add(i))
                return true;
        }
        return false;
    }

}
