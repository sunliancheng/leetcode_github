package LC0_200.LC150_200;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC179_Largest_Number {

    @Test
    public void test() {
        largestNumber(new int[]{30,34,3});
    }

    public String largestNumber(int[] nums) {
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; ++i)
            asStrs[i] = String.valueOf(nums[i]);

        Arrays.sort(asStrs, (String a, String b) -> (b + a).compareTo(a + b));
        if(asStrs[0].equals("0")) return "0";

        String largestNumStr = new String();
        for (String num : asStrs)
            largestNumStr += num;

        return largestNumStr;
    }


}
