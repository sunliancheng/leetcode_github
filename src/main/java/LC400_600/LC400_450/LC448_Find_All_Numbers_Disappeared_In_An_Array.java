package LC400_600.LC400_450;

import java.util.ArrayList;
import java.util.List;

public class LC448_Find_All_Numbers_Disappeared_In_An_Array {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        boolean[] bucket = new boolean[nums.length];
        for (int i : nums)
            if (!bucket[i - 1])
                bucket[i - 1] = true;
        for (int i = 0; i < nums.length; ++i)
            if (!bucket[i])
                res.add(i + 1);
        return res;
    }


}
