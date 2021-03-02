package LC200_400.LC200_250;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LC228_Summary_Rangs {

    @Test
    public void test() {
        summaryRanges(new int[]{0,1,2,4,5,7});
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        boolean flag = false;
        // if num[i] + 1 < num[i + 1], cut it
        int i = 1, prev = nums[0], start_value = nums[0];
        while (i < nums.length) {
            if (nums[i] > prev + 1) {
                StringBuilder sb = new StringBuilder();
                sb.append(start_value);
                if (start_value != prev)
                    sb.append("->").append(prev);
                result.add(sb.toString());
                start_value = nums[i];
                prev = nums[i];
            } else
                prev = nums[i];
            i++;
        }
        if (true) {
            StringBuilder sb = new StringBuilder();
            sb.append(start_value);
            if (start_value != prev)
                sb.append("->").append(prev);
            result.add(sb.toString());
        }
        return result;
    }

}
