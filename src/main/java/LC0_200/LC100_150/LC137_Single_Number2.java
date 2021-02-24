package LC0_200.LC100_150;

import org.junit.Test;

public class LC137_Single_Number2 {

    public int singleNumber(int[] nums) {
        int seenOnce = 0, seenTwice = 0;
        for (int i : nums) {
            seenOnce = ~seenTwice & (seenOnce ^ i);
            seenTwice = ~seenOnce & (seenTwice ^ i);
        }
        return seenOnce;
    }

    @Test
    public void test() {
        int[] nums = new int[]{2,2,2,3};
        System.out.println(singleNumber(nums));
    }

}
